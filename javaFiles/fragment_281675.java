import java.net.*;
import java.io.*;
import java.util.*;

class SimpleClient {
    public static void main(String args[]) throws Exception {

        // Preparing the queues
        List<testobject> sendQueue = Arrays.asList(
            new testobject(1,"object 1","field1","field2","field3","field4"),
            new testobject(2,"object 3","field1","field2","field3","field4"));
        List<testobject> receiveQueue = new ArrayList<testobject>();

        // Connection setup
        Socket s = new Socket("localhost",2002);
        OutputStream os = s.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        InputStream is = s.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        testobject to;

        // Conversation, we start by sending
        for (testobject toSend: sendQueue) {
            System.out.println("Sending " + toSend.id);
            oos.writeObject(toSend);
            testobject received = (testobject)ois.readObject();
            System.out.println("Received " + received.id);
            receiveQueue.add(received);
        }

        // Connection shutdown
        ois.close();
        oos.close();
        s.close();
    }
}

class SimpleServer {
    public static void main(String args[]) throws Exception {

        // Preparing the queues
        List<testobject> sendQueue = Arrays.asList(
            new testobject(2,"object 2","field1","field2","field3","field4"),
            new testobject(4,"object 4","field1","field2","field3","field4"));
        List<testobject> receiveQueue = new ArrayList<testobject>();

        // Connection setup
        ServerSocket ss = new ServerSocket(2002);
        Socket s = ss.accept(); // only handle a single connection
        ss.close(); // so we can immediately stop listening for more
        OutputStream os = s.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        InputStream is = s.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        testobject to;

        // Conversation, we start by receiving
        for (testobject toSend: sendQueue) {
            testobject received = (testobject)ois.readObject();
            System.out.println("Received " + received.id);
            receiveQueue.add(received);
            System.out.println("Sending " + toSend.id);
            oos.writeObject(toSend);
        }

        // Connection shutdown
        ois.close();
        oos.close();
        s.close();
    }
}