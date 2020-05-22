while (true) {
    final Socket socket = serverSocket.accept();
    new Thread(() -> {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            boolean quit = false;
            while (!quit) {
                String msgClient = in.readLine();
                quit = msgClient.trim().equals("quit");
                System.out.println("Received: " + msgClient);
                String msgServeur = msgClient.toUpperCase() + '\n';
                out.writeBytes(msgServeur);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }).start();
}