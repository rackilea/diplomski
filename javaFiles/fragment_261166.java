import java.io.*;
import java.net.*;

public class NetworkTransfers { 

public Socket s = null;
public ObjectOutputStream oos = null;
public ObjectInputStream ios = null;

public void activateNetwork()
{
    try {
        s = new Socket("IP-address", Port);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    try {
        oos = new ObjectOutputStream(s.getOutputStream());
        ios = new ObjectInputStream(s.getInputStream());
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }       

}

public void closeConnections()
{
    try {
        s.close();
        ios.close();
        oos.close();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

}

}