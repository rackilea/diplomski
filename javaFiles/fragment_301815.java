public class ForwardAndChangeCaseThread extends Thread {
    private Socket in, out;
    public ForwardAndChangeCaseThread(Socket in, Socket out) {
        this.in = in; this.out = out;
    }
    public void run() {
        byte[] buf = new byte[4096];
        InputStream in = this.in.getInputStream();
        OutputStream out = this.out.getOutputStream();
        int count;
        while ((count = in.read(buf)) > 0) {
            for (int i = 0; i < count; i++)
                if (buf[i] >= 0x40) buf[i] ^= 0x20;
            out.write(buf, 0, count);
        }
    }
}
public class TcpForwarder {
    public static void main(String[] args) {
        ServerSocket listen = new ServerSocket(8080, 1);
        for (;;) {
            Socket local = listen.accept();
            Socket remote = new Socket("localhost", 80);
            new ForwardAndChangeCaseThread(local, remote).start();
            new ForwardAndChangeCaseThread(remote, local).start();
        }
    }
}