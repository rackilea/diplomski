package arrayListRMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", Constants.RMI_PORT);
            IArrayList cmp = (IArrayList) registry.lookup(Constants.RMI_ID);
            ArrayList<String> received = cmp.getText();
            System.out.println(received);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}