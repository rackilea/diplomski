@Override
protected String doInBackground(String... params) {
    String comment = params[0];
    String response = null;
    Socket socket = null;
    try {
        socket = new Socket("www.regisscis.net", 8080);
        if (socket.isConnected()) {
            PrintWriter out = new PrintWriter(new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            Log.i(TAG_STRING, "Calling Write");
            out.println(comment);
            String resposeFromServer = in.readLine();
            out.close();
            in.close();
            response = resposeFromServer;               
            socket.close();
        } else {
            Log.i(TAG_STRING, "Socket is not connected");
        }

    } catch (UnknownHostException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    return response;
}