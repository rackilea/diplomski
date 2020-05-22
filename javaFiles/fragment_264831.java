class ServerSender implements Runnable {


    private PrintWriter writer;

    public ServerSender(PrintWriter printWriter){

        writer = printWriter;
    }

    @Override
    public void run() {
        try {

            Scanner scanner = new Scanner(System.in);

            String msg = "";
            while (!msg.equalsIgnoreCase("exit")) {
                System.out.print("Server: ");
                msg = scanner.nextLine();

                writer.println(msg);
            }

        } catch (IOException e) {
            System.err.println("Sender Error " + e);
        }
    }
}