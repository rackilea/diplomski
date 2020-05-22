public class Client implements Runnable, ResponseOutput {

    private final BufferedReader br;
    private final PrintWriter pw;

    public Client(Socket s) {
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        pw = new PrintWriter(s.getOutputStream());
    }

    // defined by the ResponseOutput interface
    public void sendReply(String reply) {
        pw.println(reply);
    }

    public void run() {
        try {
            while (true) {
                String s = br.readLine();
                if (s==null)
                    break;
                Processor.queue(new Processor.InputItem(this, s));
            }
        } catch (IOException ioe) {
            ... error handling ...
        }
    }
}