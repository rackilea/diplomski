addNetworkErrorListener(err -> { 
    // prevent the event from propagating
    err.consume();
    if(err.getError() != null) {
        Log.e(err.getError());
    }
    Log.sendLogAsync();
    Dialog.show("Connection Error", "There was a networking error in the connection to " + err.getConnectionRequest().getUrl(), "OK", null);
});