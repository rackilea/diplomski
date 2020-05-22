Runnable networkListener = () -> {
    //declare and instantiate server here
    while(true){
         Socket connection = server.accept();
         //whatever you would like to do with the connection would go here
    }
}
Thread networkThread = new Thread(networkListener);
networkThread.start();