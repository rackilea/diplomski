class ServerReceiver implements Runnable {

    private BufferedReader reader;

    public ServerReceiver(BufferedReader bufferedReader){

       reader = bufferedReader;

    }

    @Override
    public void run() {
        try {

            System.out.println(reader.readLine());
        } catch (IOException e) {
            System.err.println("Receiver Error " + e);
        }
    }
}