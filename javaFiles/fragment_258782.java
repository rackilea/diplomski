public class Server extends Thread {

public static final int PORT = 15000;

public static void main(String[] args) {
    new Server().start();
}

@Override
public void run() {
    try {
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (true) {
            Socket sock = serverSocket.accept();
            readFile(sock);
        }
    } catch (Exception e) {
    }
}

private void readFile(Socket socket) throws Exception {
    InputStream ois = socket.getInputStream();

    byte[] resultBuff = new byte[0];
    byte[] buff = new byte[1024];
    int k;
    while ((k = ois.read(buff, 0, buff.length)) > -1) {
        byte[] tbuff = new byte[resultBuff.length + k];
        System.arraycopy(resultBuff, 0, tbuff, 0, resultBuff.length);
        System.arraycopy(buff, 0, tbuff, resultBuff.length, k);
        resultBuff = tbuff;
    }

    byte lengthOfFileName = resultBuff[0];

    byte fileNameBytes[] = new byte[lengthOfFileName];
    System.arraycopy(resultBuff, 1, fileNameBytes, 0, lengthOfFileName);
    String filename = new String(fileNameBytes);

    FileOutputStream fos = new FileOutputStream(filename + System.currentTimeMillis());

    byte[] bytearr = new byte[resultBuff.length - (lengthOfFileName + 1)];
    System.out.println("Writing file...");

    System.arraycopy(resultBuff, lengthOfFileName + 1, bytearr, 0, bytearr.length);
    BufferedOutputStream bos = new BufferedOutputStream(fos);
    bos.write(bytearr);

    bos.close();
    System.out.println("Writing file complete...");
}
}