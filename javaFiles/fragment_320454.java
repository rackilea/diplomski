public void stop() {
    running = false;
    try{
        if (server != null) server.close ();
    } catch (IOException ignored){
    }
}