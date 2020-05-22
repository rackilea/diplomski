import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Client extends JFrame {
// Text field for receiving data
private JTextField jtf = new JTextField();
// Text area to display contents
private JTextArea jta = new JTextArea();
// IO streams
private  DataOutputStream toServer;
private  DataInputStream fromServer;

public static void main(String[] args) {
    new Client();
}

public Client() {
// Panel p to hold the label and text field
    JPanel p = new JPanel();
    p.setLayout(new BorderLayout());
    p.add(new JLabel("Enter word: "), BorderLayout.WEST);
    p.add(jtf, BorderLayout.CENTER);
    jtf.setHorizontalAlignment(JTextField.RIGHT);

    setLayout(new BorderLayout());
    add(p, BorderLayout.NORTH);
    add(new JScrollPane(jta), BorderLayout.CENTER);

    jtf.addActionListener(new Listener()); // Register listener

    setTitle("Client");
    setSize(500, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true); // It is necessary to show the frame here!

    try {
    // Create a socket to connect to the server
     Socket socket = new Socket("localhost", 8000);
          // Socket socket = new Socket("130.254.204.36", 8000);
          // Socket socket = new Socket("drake.Armstrong.edu", 8000);

      // Create an input stream to receive data from the server
      fromServer = new DataInputStream(
        socket.getInputStream());

      // Create an output stream to send data to the server
      toServer =
        new DataOutputStream(socket.getOutputStream());

      new Thread(new Runnable(){

        @Override
        public void run()
        {
            while(true)
            {
                String serverMessage = "";
                try
                {
                    serverMessage = fromServer.readUTF();
                }
                catch (IOException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                jta.append("Word received from the server is "
                          + serverMessage + '\n');
            }

        }})
        .start();


    }
    catch (IOException ex) {
    jta.append(ex.toString() + '\n');
    }
}

private class Listener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
        // Get the data from the text field
        String message = (jtf.getText().trim());

        // Send the data to the server
         toServer.writeUTF(message);

        // Get data from the server

         System.out.println("from server");

        // Display to the text area

        jta.append("Word is " + message + "\n");

        toServer.flush();

        }
        catch (IOException ex) {
        System.err.println(ex);
        }
    }
}
}