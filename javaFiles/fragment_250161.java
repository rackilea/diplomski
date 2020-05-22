import java.rmi.Remote;
import java.rmi.RemoteException;

// normally published object
public interface MyService extends Remote
{
    // creates something and return a "handle" to it
    public MyHandle createX(SomeSerializableObj param1) throws RemoteException;
}

// interface for object that the service will return a reference to...
public interface MyHandle extends Remote
{
    void doOne();
    void doTwo();
}