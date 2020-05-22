Class ServerThread extends Thread {
    StreamConnection connection;

    public ServerThread(StreamConnection connection){
        this.connection = connection;
    }

    public void run() {

        BufferedInputStream bis = new BufferedInputStream(this.connection.openInputStream());
        ObjectInputStream ois = new ObjectInputStream(bis);

        ArrayList contacts = (ArrayList) ois.readObject();  //this is a cast: don't forget exception handling!
        //You could also try the method ois.readUTF(); especially if you wanna use other non-Java clients

        System.out.println("INFO: Received from Bluetooth: " + contacts);
        this.connection.close();    //closing the connection...don't forget exception handling!
        //ois.close();      //do this instead of "this.connection.close()" if you want the connection to be open...i.e. to receive more data

        System.out.println("INFO: Client disconnected");

        //here you do whatever you wanna do with the contacts array, maybe add to your other contacts?
    }
}