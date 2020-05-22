import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerBoard extends JFrame
{
    private JTextArea messageArea;
    private JButton sendButton;
    private JTextField message;
    private JButton startServer;
    private TCPServer mServer;

    public ServerBoard(){
        super("ServerBoard");

        JPanel panelFields = new JPanel();
        panelFields.setLayout(new BoxLayout(panelFields,BoxLayout.X_AXIS));

        JPanel panelFields2 = new JPanel();
        panelFields2.setLayout(new BoxLayout(panelFields2,BoxLayout.X_AXIS));

        messageArea = new JTextArea();
        messageArea.setColumns(30);
        messageArea.setRows(10);
        messageArea.setEditable(false);

        sendButton = new JButton("Send");

        sendButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String msg = message.getText();
                messageArea.append("\n" + msg);
                mServer.sendMessage(msg);
                message.setText("");
            }
        });

        startServer = new JButton("Start Server");
        startServer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                startServer.setEnabled(false);

                mServer = new TCPServer(new TCPServer.OnMessageReceived(){
                    public void messageReceived(String msg){
                        messageArea.append("\n" + msg);
                    }
                });

                mServer.start();
            }
        });

        message = new JTextField();
        message.setSize(200,20);

        panelFields.add(messageArea);
        panelFields.add(startServer);

        panelFields2.add(message);
        panelFields2.add(sendButton);

        getContentPane().add(panelFields);
        getContentPane().add(panelFields2);

        getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));

        setSize(300,170);
        setVisible(true);
    }
}