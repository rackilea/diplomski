boolean running = true;    //this class variable will allow you to shut down the server correctly

public void stopServer(){    //this method will shut down the server
    this.running = false;
}

public void run() {
    ...

    while(running) {
        // if(this.connection == null) {  // I removed this line since it's unnecessary, or even harmful!
        StreamConnection connection = this.server.acceptAndOpen();  //This line will block until a connection is made...
        System.out.println("INFO: Bluetooth client connected");
        Thread thread = new ServerThread(connection);
        thread.start()              //don't forget exception handling...
    } 
}