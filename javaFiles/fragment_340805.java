try {
        // Establish connection
        Socket socket = new Socket("IP ADDRESS HERE", PORT_NUMBER);

        // Request data
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        outputStream.writeUTF("Hello World!");

        // Read data
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        message = inputStream.readUTF();

        // Shut down socket
        socket.shutdownInput();
        socket.shutdownOutput();
        socket.close();
    } catch (IOException io) {
        io.printStackTrace();
    }