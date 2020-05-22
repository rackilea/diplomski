import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;

import javax.swing.*;

public class Server extends JFrame {
// Text area for displaying contents
private static JTextArea jta = new JTextArea();
LinkedList<Handler> handlers = new LinkedList<Handler>();

public static void main(String[] args) {
    new Server();
}

public void sendmessagetoall(String message)
{
    for(Handler current : handlers)
    {
        try
        {
            current.writeMessage(message);
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

public Server() {

    setLayout(new BorderLayout());
    add(new JScrollPane(jta), BorderLayout.CENTER);

    setTitle("Server");
    setSize(500, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true); // It is necessary to show the frame here!

    // Place text area on the frame
    try {
    // Create a server socket
    ServerSocket serverSocket = new ServerSocket(8000);
    jta.append("Server started at " + new Date() + '\n');
    try {
        while (true) {
            Handler noob =  new Handler(serverSocket.accept(),this);
            handlers.add(noob);
            noob.start();
        }
    } finally {
        serverSocket.close();
    }

}
catch(IOException ex) {
    System.err.println(ex);
    }
}

public static class Handler extends Thread{

    Socket socket;
    Server parent;
    DataInputStream inputFromClient;
    DataOutputStream outputToClient;

    public Handler(Socket socket, Server parent){
        this.socket = socket;
        this.parent = parent;
    }

    public void writeMessage(String message) throws IOException
    {
        outputToClient.writeUTF(message);
    }

    public void run(){
        // Listen for a connection request
          //Socket socket = serverSocket.accept();
          try{
        // Create data input and output streams
           inputFromClient = new DataInputStream(socket.getInputStream());
           outputToClient = new DataOutputStream(socket.getOutputStream());

            while (true) {

            // Receive data from the client
            String message =inputFromClient.readUTF();

            System.out.println("Server: Receive input");

            jta.append("Word received from client: " + message + '\n');


            // DO converting process
            //String newMessage ="";
            //newMessage= message.toUpperCase();
            // Send data back to the client
            //writeMessage(message);
            parent.sendmessagetoall(message);
            //jta.append("Word Converted: " + newMessage + '\n');

            }
          }catch(IOException ex) {
            System.err.println(ex);
            }
        } 
    }
}