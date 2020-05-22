public void initializeStreams() throws ConnectException {
try {
    Log.i(TAG, "Attempting to connect");

    requestSocket = new Socket(SERVER_ADDR, PORT);

                /* other code */


} catch(ConnectException e){
    throw e;
}

catch (IOException e) {
    e.printStackTrace();
}