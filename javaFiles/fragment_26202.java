import org.freedesktop.dbus.DBusInterface;
import org.freedesktop.dbus.DBusInterfaceName;    

@DBusInterfaceName("org.printer")
public interface DBus extends DBusInterface {
    //Methods to export
    public void Print(String message);
}