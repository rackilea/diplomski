import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;
import javax.microedition.midlet.*;


public class AsyncUI extends MIDlet implements SearchListener, CommandListener{
    Command CANCEL = new Command("STOP SEARCH",Command.CANCEL,1);
    Command EXIT = new Command("EXIT",Command.EXIT,2);
    SearchDevices finder = new SearchDevices();
    List deviceList = new List("List of Devices",List.IMPLICIT);

    public void startApp() {
        Display d = Display.getDisplay(this);
        finder.setSearchListener(this);
        deviceList.addCommand(CANCEL);
        deviceList.addCommand(EXIT);
        deviceList.setCommandListener(this);
        d.setCurrent(deviceList);
        new Thread( finder).start();
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void found( Device d){
        deviceList.append(d.getName(), null);
    }
    public void commandAction( Command c, Displayable d){

        if( c == CANCEL){
            finder.cancel();
            deviceList.removeCommand(CANCEL);
        }else if( c== EXIT ){
            finder.cancel(); /* Cleanup all resources before you quit*/
            notifyDestroyed();
        }
    }
}

class SearchDevices implements Runnable{

    private boolean keepFinding=true;
    private static final int LONG_TIME=10000; /* 10 Seconds */
    SearchListener l =null; /* Currently only one listener. There could be many*/

    public void run(){
        int i =0;
        System.out.println(" -- Started the activity of finding --");
        while( keepFinding){
            try {
                Thread.currentThread().sleep(LONG_TIME);
                Device d = new Device("Device Found "+i);
                i++;
                System.out.println(" -- Found the device --");
                l.found(d);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println(" -- No more devices will be found  --");
    }

    public void cancel(){ keepFinding = false; }
    public void setSearchListener( SearchListener l){this.l=l;}


}

    class Device{
        String name;
        public Device(String name ){ this.name = name; }
        public String getName(){ return name ; }
    }

    interface SearchListener{
        public void found( Device device);
    }