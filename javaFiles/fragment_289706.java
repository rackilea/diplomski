private void runTcpServer() {
    ServerSocket ss = null;
    try {
        ss = new ServerSocket(TCP_SERVER_PORT);
        Log.d("TcpServer", ss.getInetAddress()+"");
        //ss.setSoTimeout(10000);
        //accept connections
        Socket s = ss.accept();
        Log.i("TcpServer", "Receiving");
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        //BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        //receive a message
        Log.i("TcpServer", in.readLine());
        final String incomingMsg = in.readLine() + System.getProperty("line.separator");
        Log.i("TcpServer", "received: " + incomingMsg);
        runOnUiThread(new Runnable() {
            public void run() {
                texto.append("received: " + incomingMsg);
            }
        });

        s.close();
    } catch (InterruptedIOException e) {
        //if timeout occurs
        e.printStackTrace();
        Log.e("TcpServer", ""+e);
    } catch (IOException e) {
        e.printStackTrace();
        Log.e("TcpServer", ""+e);
    } finally {
        if (ss != null) {
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("TcpServer", ""+e);
            }
        }
    }
}