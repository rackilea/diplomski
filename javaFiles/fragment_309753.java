package sampleserver;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.Object.*;

public class serverTest extends JFrame {
    private JTextField userText; //message variable area
    private JTextArea chatWindow; //display the conversation
    private ServerSocket server; //server variable
    private Vector<String> users;
    private Vector<String> ips;
    private JTextArea conList;
    private ArrayList<SampleServer> connections = new ArrayList<SampleServer>();

    public static void main(String[] args){
        new serverTest();
    }

    public serverTest()
    {
        super("Instant Messenger");
        userText = new JTextField(); //text field
        userText.addActionListener(
                new ActionListener(){
                    public void actionPerformed (ActionEvent event){
                        sendMessage(event.getActionCommand()); //sends the message
                        userText.setText("");
                    }
                }
        );
        add(userText, BorderLayout.SOUTH);
        users = new Vector();
        ips = new Vector();
        chatWindow = new JTextArea();
        conList = new JTextArea();
        conList.setEditable(false);
        add(new JScrollPane(chatWindow));
        add(new JScrollPane(conList), BorderLayout.EAST);
        conList.append("   ONLINE USERS    \n");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

       try {
           server = new ServerSocket(6789, 100); //port number and only 100 can connect to the server
           while(true){
               try{
                    showMessage("Waiting for someone to connect...\n");
                    Socket connection = server.accept(); //once someone asked for connection, accepts this
                    //showMessage("Now connected to "+connection.getInetAddress().getHostName()); //converts the ip address to string

                    ips.add(connection.getInetAddress().getHostName()); // adds ip address of client to ips vector

                    BufferedReader fromC = new BufferedReader(new InputStreamReader(connection.getInputStream())); // gets what client sent through printwriter - username
                    String s = new String(fromC.readLine()); // saves as string
                    users.add(s); // saves username of client to users vector
                    String con = (connection.getInetAddress().getHostName());
                    showMessage(s + " / " + con + " has connected.");

                    Iterator c = users.iterator(); // username iterator
                    Iterator b = ips.iterator(); // ip address iterator

                    conList.setText("");

                    while(c.hasNext()) {

                        String d = (c.next()).toString(); // gets next element in users vector
                        String e = (b.next().toString()); // gets next element in ips vector
                        conList.append(d + "\n"); // displays username in online users list
                        conList.append("(" + e + ")\n\n"); // displays ip in online users list
                    }
                    final SampleServer se = new SampleServer(connection, s, con, this);
                    Thread t = new Thread(new Runnable(){
                        public void run()
                        {
                            se.run();
                        }
                    });
                    connections.add(se);
               }catch(EOFException eofException){
                   showMessage("\n Server ended the connection!");
               }
           }

       }catch(IOException ioException){
           ioException.printStackTrace();
       }
    }

    public void closeAll()
    {
        while (!connections.isEmpty())
        {
            connections.get(0).closeAll();
            connections.remove(0);
        }
    }

    public void sendMessage(String text)
    {
                showMessage("\n SERVER - " + text);
        for (SampleServer s : connections)
        {
            s.sendMessage(text);
        }
    }

    public void showMessage(final String text)
    {
       SwingUtilities.invokeLater( //updats GUI or threads
               new Runnable(){
                   public void run(){
                       chatWindow.append(text); //add string at the end of the chatWindow
                   }
               }
       );
    }
}