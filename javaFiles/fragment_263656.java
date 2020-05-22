public void run() {
    try {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader in = new BufferedReader(inputStreamReader);
            while (true) {
                System.out.print("Waiting for input.");
                String messageFromClient = in.readLine();
                System.out.print(messageFromClient);
            }
        } finally {
            socket.close();
        }
    } catch (IOException exception) {
        System.out.print(exception);
        // TODO: handle exception
    }
}