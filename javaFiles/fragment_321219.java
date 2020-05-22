package arrayListRMI;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;


public class Server {
    public static void main(String args[]) throws AlreadyBoundException, SQLException, ClassNotFoundException {

        try {
            ArrayList<String> textRequested = new ArrayList<String>();
            textRequested.add("example1");
            textRequested.add("example2");
            ArrayListImpl arrayListToSend = new ArrayListImpl();
            arrayListToSend.setText(textRequested);
            Registry registry = LocateRegistry.createRegistry(Constants.RMI_PORT);
            registry.bind(Constants.RMI_ID, arrayListToSend);
            System.out.println("Server starts....");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}