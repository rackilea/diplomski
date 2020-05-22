new Thread(new Runnable() {
    @Override
    public void run() {
      while (mReceiving) {

        Socket recSocket = null;

        try {
            recSocket = mServerSocket.accept();

            // Process connection
            mTcpServerHandler.onIncomingConnection(recSocket);

        } catch (IOException e) {
                // ...
        } finally {
            if (recSocket != null) {
                try {
                    recSocket.close();
                } catch (IOException e) {
                    // log, ignore...
                }
            }
        }
     }
   }
 }).start();