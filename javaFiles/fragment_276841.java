public void connectConnection()
    {
        AsyncTask<Void, Void, Boolean> connectionThread = new AsyncTask<Void, Void, Boolean>() {

            @Override
            protected Boolean doInBackground(Void... arg0) {

                // Create a connection
                try {
                    connection.connect();
                    login();
                    connected = true;

                } catch (IOException e) {
                } catch (SmackException e) {

                } catch (XMPPException e) {
                }

                return null;
            }
        };
        connectionThread.execute();
    }