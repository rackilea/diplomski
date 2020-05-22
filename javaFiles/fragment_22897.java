import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class EmailProg extends JFrame {
    private JPanel panNorth;
    private JPanel panCenter;
    private JPanel panSouth;

    private JLabel toLabel;
    private JLabel ccLabel;
    private JLabel bccLabel;
    private JLabel subLabel;
    private JLabel msgLabel;

    private JTextField toField;
    private JTextField ccField;
    private JTextField bccField;
    private JTextField subField;
    private JTextArea msgArea;

    private JButton send;

    // The Constructor
    public EmailProg() {
        setTitle("Compose Email");
        setLayout(new BorderLayout());

        panNorth = new JPanel();
        panNorth.setLayout(new GridLayout(4, 2));
        toLabel = new JLabel("To:");
        panNorth.add(toLabel);
        toField = new JTextField(15);
        panNorth.add(toField);
        ccLabel = new JLabel("CC:");
        panNorth.add(ccLabel);
        ccField = new JTextField(15);
        panNorth.add(ccField);
        bccLabel = new JLabel("Bcc:");
        panNorth.add(bccLabel);
        bccField = new JTextField(15);
        panNorth.add(bccField);
        subLabel = new JLabel("Subject:");
        panNorth.add(subLabel);
        subField = new JTextField(15);
        panNorth.add(subField);
        add(panNorth, BorderLayout.NORTH);

        panCenter = new JPanel();
        panCenter.setLayout(new GridLayout(2, 1));
        msgLabel = new JLabel("Message:");
        panCenter.add(msgLabel);
        msgArea = new JTextArea(5, 15);
        panCenter.add(msgArea);
        add(panCenter, BorderLayout.CENTER);

        panSouth = new JPanel();
        panSouth.setLayout(new FlowLayout());
        send = new JButton("Send");
        panSouth.add(send);
        add(panSouth, BorderLayout.SOUTH);

        send.addActionListener(new SendAction());
    }

    private class SendAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {
                PrintWriter outfile = new PrintWriter("email.txt");
                outfile.print("To: ");
                outfile.println(toField.getText());
                outfile.print("CC: ");
                outfile.println(ccField.getText());
                outfile.print("Bcc: ");
                outfile.println(bccField.getText());
                outfile.print("Subject: ");
                outfile.println(subField.getText());
                outfile.print("Message: ");
                outfile.println(msgArea.getText());

                JOptionPane.showMessageDialog(null, "Saved");
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
            }
        }
    }

    public static void main(String[] args) {

        //Make sure that all your operations happens through the EDT
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                EmailProg win = new EmailProg();
                win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                win.pack();
                win.setVisible(true);

            }
        });
    }
}