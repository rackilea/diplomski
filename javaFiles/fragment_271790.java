Executor exe = Executors.newCachedThreadPool();
ServerSocket serverSocket = null;
try {
    serverSocket = new ServerSocket(8888);
} catch (IOException e) {
    System.err.println("Could not listen on port: 8888");
    System.exit(-1);
}
while (listening) {
    final Socket clientSocket = serverSocket.accept();

    exe.execute(new Runnable() {

        @Override
        public void run() {
            try {
                Scanner reader = new Scanner(clientSocket.getInputStream());
                while(reader.hasNextLine()){
                    String line = reader.nextLine();
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    });

}
serverSocket.close();