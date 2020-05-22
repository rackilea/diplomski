import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientSocketFrame extends JFrame implements ActionListener {
    JLabel lblName;
    JLabel lblAge;
    JLabel lblMark;
    JTextField txtName;
    JTextField txtAge;
    JTextField txtMark;
    JButton btnProcess;
    JTextArea txtS;

    public ClientSocketFrame() {
        this.setTitle("Simple Sample");
        this.setSize(320, 240);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lblName = new JLabel("Name: ");
        lblName.setBounds(10, 10, 90, 21);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(105, 10, 90, 21);
        add(txtName);

        lblAge = new JLabel("Age: ");
        lblAge.setBounds(10, 35, 90, 21);
        add(lblAge);

        txtAge = new JTextField();
        txtAge.setBounds(105, 35, 90, 21);
        add(txtAge);

        lblMark = new JLabel("Mark: ");
        lblMark.setBounds(10, 60, 90, 21);
        add(lblMark);

        txtMark = new JTextField();
        txtMark.setBounds(105, 60, 90, 21);
        add(txtMark);

        btnProcess = new JButton("Process");
        btnProcess.setBounds(200, 40, 90, 21);
        btnProcess.addActionListener(this);
        add(btnProcess);

        txtS = new JTextArea();
        txtS.setBounds(10, 85, 290, 120);
        add(txtS);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ClientSocketFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnProcess)) {
            try {
                processInformation();
            } catch (UnknownHostException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void processInformation() throws UnknownHostException, IOException {
        Socket s = new Socket("localhost", 5000);
        ObjectOutputStream p = new ObjectOutputStream(s.getOutputStream());

        String name = txtName.getText();
        int mark = Integer.parseInt(txtMark.getText());
        int age = Integer.parseInt(txtAge.getText());

        p.writeObject(new Student(name, age, mark));
        p.flush();

        // Here we read the details from server
        BufferedReader response = new BufferedReader(new InputStreamReader(
                s.getInputStream()));
        txtS.setText("The server respond: " + response.readLine());
        p.close();
        response.close();
        s.close();
    }

}