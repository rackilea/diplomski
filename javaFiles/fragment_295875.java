class InternetCheckTask extends AsyncTask<InetAddress, Void, Boolean> {

    @Override
    protected Boolean doInBackground(InetAddress... inetAddresses) {
        try {
            InetAddress inetAddress = inetAddresses[0];
            Socket sock = new Socket();
            SocketAddress sockaddr = new InetSocketAddress(inetAddress.address, inetAddress.port);

            sock.connect(sockaddr, inetAddress.timeOutAfterMs); // This will block no more than timeoutMs
            sock.close();

            return true;

        } catch (IOException e) { return false; }
    }

    @Override
    protected void onPostExecute(Boolean isInternetAvailable) {
        // Note: this will be executed on the main thread
        if(isInternetAvailable){
            doSomething();
        }
        else{
            Toast.makeText(MainActivity.this , "Internet not available", Toast.LENGTH_SHORT ).show();
        }
    }
}