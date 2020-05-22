import org.freedesktop.dbus.DBusConnection;
import org.freedesktop.dbus.exceptions.DBusException;

public class Main {    
    public static void main(String[] args) {
        Printer p = new Printer();

        try {
            DBusConnection conn = DBusConnection.getConnection(DBusConnection.SESSION);
            //Creates a bus name, it must contain some dots.
            conn.requestBusName("org.printer");
            //Exports the printer object
            conn.exportObject("/org/printer/MessagePrinter", p);
       } catch (DBusException DBe) {
           DBe.printStackTrace();
           conn.disconnect();
           return;
       }
    }
}

//Printer object, implements the dbus interface and gets
//called when the methods are invoked.
class Printer implements DBus {
    public boolean isRemote() {
        return false;
    }

    public void Print(String message) {
        System.out.println(message);
    }
}