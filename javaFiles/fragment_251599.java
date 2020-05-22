import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import java.io.IOException;

public class Deneme1 extends JFrame implements ActionListener {

    JTextField value = new JTextField(20);
    JButton tryFetch;
    // declared as a class attribute, this can be accessed 
    // in the action performed method
    JComboBox select; 

    public static void main(String[] args) {
        Deneme1 windows = new Deneme1("Deneme1 ");
        windows.setSize(400, 200);
        windows.setLocation(430, 100);
        windows.setVisible(true);
        windows.setTitle("Title");
    }

    public Deneme1(String title) {
        JLabel text2 = new JLabel("Pick one: ");
        add(text2);
        select = new JComboBox();
        select.addItem("A");
        select.addItem("B");
        add(select);
        JLabel text1 = new JLabel("Enter value:");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tryFetch = new JButton("Try");
        add(text1);
        add(value);
        add(tryFetch);
        tryFetch.addActionListener(this);
    }

    public void actionPerformed(ActionEvent E) {
        String selected = (String) select.getSelectedItem();
        switch (selected) {
            case "A":
                try {
                    URI AcilacakSite = new URI("https://A" + value.getText());
                    Desktop.getDesktop().browse(AcilacakSite);
                } catch (URISyntaxException | IOException ex) {
                    JOptionPane.showMessageDialog(null, "ERR");
                }
                break;
            case "B":
                try {
                    URI AcilacakSite = new URI("https://B" + value.getText());
                    Desktop.getDesktop().browse(AcilacakSite);
                } catch (URISyntaxException | IOException ex) {
                    JOptionPane.showMessageDialog(null, "ERR");
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "ERR");
                break;
        }
    }
}