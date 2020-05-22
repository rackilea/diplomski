public class MySocket implements Runnable {

    int worker_thread = 2;
    volatile boolean shouldRun = true;
    ServerSocket server;
    int port = 8117;
    ExecutorService services;

    public MySocket() throws IOException {
        this.server = new ServerSocket(port);
        services = Executors.newFixedThreadPool(this.worker_thread);
    }

    // A METHOD TO RUN SERVER THREAD
    @Override
    public void run() {
        while (this.shouldRun) {
            Socket client = null;
            try {
                client = server.accept();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            // hand it over to be processed
            this.services.execute(new ClientSessions(client));
        }
    }

    public static void main(String[] ar) throws Exception {
        new MySocket().run();
    }
}

class ClientSessions implements Runnable {
    Socket s;
    public ClientSessions(Socket s) {
        this.s = s;
    }
    @Override
    public void run() {
        // get the data
        try (DataInputStream dis = new DataInputStream(this.s.getInputStream());
                DataOutputStream dos = new DataOutputStream(this.s.getOutputStream())) {
            // read the name
            // this works
            String name = dis.readUTF();
            String PATH_TO_SAVE = name;
            // now copy file to disk
            File f = new File("c://folder", PATH_TO_SAVE);
            Files.copy(dis, f.toPath());
            dos.writeUTF("Succesful");
            System.out.println("I am done");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}