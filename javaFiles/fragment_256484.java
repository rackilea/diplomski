public class ServerThread extends Thread {
    private final Socket socket;
    private final List<PrintWriter> outs;

    public ServerThread(Socket socket, List<PrintWriter> outs) {
        super("ServerThread");
        this.socket  = socket;
        this.outs = outs;
        System.out.println("Opened outs: " + outs.size());
    }

    private void sendToAll(String msg) throws IOException {
        for(PrintWriter out: outs) {
            out.println(msg);
        }
    }

    public void run() {
        try (
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            System.out.println("stream opened");
            outs.add(out);
            String getMSGs;
            while((getMSGs = in.readLine()) != null) {
                System.out.println("msg received and sent " + getMSGs);
                sendToAll(getMSGs);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}