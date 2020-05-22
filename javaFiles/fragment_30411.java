MainActivity activity;

public Client(MainActivity activity) {
    connected = false;
    this.activity = activity;
}
...

public void run() {
       String msg = ""; //holds the msg recieved from server
       try {
          while(connected && (msg = br.readLine())!= null)
          {
             //In Here I want to call MainActivity.displayServerAnswer()
             activity.displayServerAnswer();

             //notify observers//
             this.setChanged();
             //notify+send out recieved msg to Observers
             this.notifyObservers(msg);
          }
       }
       catch(IOException ioe) { }
       finally { connected = false; }
  }