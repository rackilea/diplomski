import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;

/**
 * Created by peter on 1/25/15.
 */
public class DataSocket implements Closeable {
    private final Socket socket;
    private final DataOutputStream out;
    private final DataInputStream in;

    public DataSocket(Socket socket) throws IOException {
        this.socket = socket;
        this.out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        this.in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
    }

    @Override
    public void close() throws IOException {
        out.flush();
        socket.close();
    }

    // message format is length as UTF-8 encoded name, 32-bit int followed by data.
    public void writeMessage(String description, byte[] bytes) throws IOException {
        out.writeUTF(description);
        out.writeInt(bytes.length);
        out.write(bytes);
        out.flush();
    }

    public byte[] readMessage(String[] description) throws IOException {
        description[0] = in.readUTF();
        int length = in.readInt();
        byte[] bytes = new byte[length];
        in.readFully(bytes);
        return bytes;
    }

    public void writeFile(File file) throws IOException {
        long length = file.length();
        if (length > Integer.MAX_VALUE) throw new IllegalArgumentException("length=" + length);
        out.writeUTF(file.toString());
        out.writeInt((int) length);
        byte[] buffer = new byte[(int) Math.min(length, 32 * 1024)];
        try (FileInputStream fis = new FileInputStream(file)) {
            for (int len; (len = fis.read(buffer)) > 0; ) {
                out.write(buffer, 0, len);
            }
        }
        out.flush();
    }

    public void readFile(File dir) throws IOException {
        String fileName = in.readUTF();
        int length = in.readInt();
        byte[] buffer = new byte[(int) Math.min(length, 32 * 1024)];
        try (FileOutputStream fos = new FileOutputStream(new File(dir, fileName))) {
            while (length > 0) {
                int len = in.read(buffer);
                fos.write(buffer, 0, len);
                length -= len;
            }
        }
    }

    // todo convert to a unit test
    public static void main(String[] args) throws IOException {
        // port 0 opens on a random free port.
        ServerSocket sc = new ServerSocket(0);
        DataSocket ds1 = new DataSocket(new Socket("localhost", sc.getLocalPort()));
        DataSocket ds2 = new DataSocket(sc.accept());
        sc.close();
        // now ds1 and ds2 are connected.
        File f = File.createTempFile("deleteme","");
        f.deleteOnExit();
        try (FileOutputStream fos = new FileOutputStream(f)) {
            fos.write(new byte[10001]);
        }
        // send a request
        ds1.writeMessage("Send me the file", new byte[0]);
        String[] desc = { null };
        byte[] data = ds2.readMessage(desc);
        if (!desc[0].equals("Send me the file")) throw new AssertionError();
    // return a response
        ds2.writeFile(f);
        f.delete();
        if (f.exists()) throw new AssertionError();
        ds1.readFile(new File(""));
        if (f.length() != 10001) throw new AssertionError("length="+f.length());
        ds1.close();
        ds2.close();
        System.out.println("Copied a "+f.length()+" file over TCP");
    }
}