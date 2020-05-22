String response = "";
    try {

        Socket socket = new Socket("127.0.0.1", 8765);

        Reader reader = new InputStreamReader(socket.getInputStream());
        OutputStream outSocket = socket.getOutputStream();

        String str = "Hello!\n";
        byte buffer[] = str.getBytes();
        outSocket.write(buffer);

        CharArrayWriter result = new CharArrayWriter();
        char[] buf = new char[4096];
        int charsRead = 0;
        while ((charsRead = reader.read(buf)) != -1) {
            result.write(buf, 0, charsRead);
        }
        response = result.toString();

        if (str.equalsIgnoreCase("bye")) {
            socket.close();
        }
    } catch (Exception e) {
        e.printStackTrace();
        response = "You must first start the server application (YourServer.java) at the command prompt.";
    }
    text.setValue(response);