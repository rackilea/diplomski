public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = null;


    try {
        serverSocket = new ServerSocket(2000);
        System.out.println("Connection Socket Created");
->      acception.start();
    } catch (IOException e) {
        System.err.println("Could not listen on port: 2000.");
        System.exit(1);
    }


    //support to close, using the command line.

    Scanner scn = new Scanner(System.in);
    String s = scn.next();

    while(true) {
        if("quit".equals.(s)) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                System.err.println("Could not close port: 2000.");
                System.exit(1);
            } finally {
                break;
            }
        }
        s = scn.next();
    }
}