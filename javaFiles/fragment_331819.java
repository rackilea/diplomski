import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class ContactListFrame extends JFrame{
    JButton Button1, Button2;
    JTextField textField1, textField2, textField3;
    JLabel label1, label2, label3 , label4;
    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints Constraint = new GridBagConstraints();

    public ContactListFrame() {
        super("All Contacts");
        Button1 = new JButton("Add");
        Button2 = new JButton("Cancel");
        textField1 = new JTextField(15);
        textField2 = new JTextField(15);
        textField3 = new JTextField(15);
        label4 = new JLabel("Add Contact");
        label4.setFont (new Font("fallan", 1, 25));
        label1 = new JLabel("First Name:");
        label2 = new JLabel("Last Name:");
        label3 = new JLabel("Phone Number:");

        setLayout(layout);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        setResizable(false);
        Constraint.fill = GridBagConstraints.BOTH;
        Insets ins = new Insets(5, 5, 5, 5);
        Constraint.insets = ins;//this does the padding
        Constraint.weightx = 0.0;
        Constraint.gridwidth = GridBagConstraints.REMAINDER;//end row
        add(label4, Constraint);
        Constraint.gridwidth = GridBagConstraints.RELATIVE;//next to last component
        add(label1, Constraint);
        Constraint.gridwidth = GridBagConstraints.REMAINDER;//end row
        add(textField1, Constraint);
        Constraint.gridwidth = GridBagConstraints.RELATIVE;//next to last component
        add(label2, Constraint);
        Constraint.gridwidth = GridBagConstraints.REMAINDER;//end row
        add(textField2, Constraint);
        Constraint.gridwidth = GridBagConstraints.RELATIVE;//next to last component
        add(label3, Constraint);
        Constraint.gridwidth = GridBagConstraints.REMAINDER;//end row
        add(textField3, Constraint);
        Constraint.gridwidth = GridBagConstraints.RELATIVE;//next to last component
        add(Button1, Constraint);
        Constraint.gridwidth = GridBagConstraints.REMAINDER;//end row
        add(Button2, Constraint);
    }        

    public static void main(String args[]) {
      new ContactListFrame().setVisible(true);
    }
}