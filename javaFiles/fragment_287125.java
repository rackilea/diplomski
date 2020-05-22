Public class BluetoothManager extends Thread{
    boolean running = true;    //this class variable will allow you to shut down the server correctly
    GUIController controller;

    public BluetoothManager(GUIController controller){
        this.controller = controller;  //this registers the GUIController in the BluetoothManager
    }

    public void stop(){    //this method will shut down the "server"
        this.running = false;
    }

    public void run() {
        this.localDevice = LocalDevice.getLocalDevice();
        this.localDevice.setDiscoverable(DiscoveryAgent.GIAC);
        this.server = (StreamConnectionNotifier) Connector.open(URL);
        while(running){
            StreamConnection connection = this.server.acceptAndOpen();  //This line will block until a connection is made...or running==false!
            System.out.println("INFO: Bluetooth client connected");
            BufferedInputStream bis = new BufferedInputStream(this.connection.openInputStream());
            ObjectInputStream ois = new ObjectInputStream(bis);
            ArrayList contacts = (ArrayList) ois.readObject();  //this is a cast: don't forget exception handling!
            System.out.println("INFO: Received from Bluetooth: " + contacts);
            this.connection.close();    //closing the connection...don't forget exception handling!
            System.out.println("INFO: Client disconnected");
            this.controller.refreshContacts(contacts);
        }
    } 
}

public class GUIController extends Thread implements Runnable {
    ArrayList contacts;   //also a HashMap may be appropriate
    BluetoothManager manager;

    public void run(){
        this.contacts = new ArrayList();
        FileReader fr = new FileReader ("C:\WhereverYourFileIs\Contacts.file");
        BufferedReader br = new BufferedReader(fr);
        //here you use a loop to read the contacts via "br" from the file and fill them into your array...I can't provide you more code, since the exact data structure is up to you.
    }

    public void startBluetoothManager(){    //starting the BluetoothManager
        this.manager = new BluetoothManager(this);
        this.manager.start();
    }

    public void abortBluetoothManager(){  //call this when clicking on the "Abort" button
        this.manager.stop();
        //now the next 2 lines you normally don't need...still may use it if you've problems shutting down the thread:
        // try{ this.manager.interrupt(); }   //we want to be 100% sure to shut down our thread!
        // catch(Exception e){}
        this.manager = null; //now the garbage collector can clean everything...byebye
    }

    public void refreshContacts(ArrayList contacts) {
        // synchronize(this.contactArray){  //no synchronisation needed if you have a GUI pop-up with an "Abort"-button!
        Iterator i = this.contacts.iterator();
        while(i.hasNext()){
            this.contacts.add(i.next());
        }
        //At the end you need remove the "Receiving message" pop-up together with the "Abort Receiving"-button, these are all class variables!
        // important note: If you have unique entries, you may need to replace them! In this case I suggest storing all contact objects better in a HashMap contacts, and use the unique ID as a key to find the element. And then you may prompt the user, if there are identical entries, to overwrite each entry or not. These things remain all up to you.
    }
}
//As always: This is no compiled code!!