import java.awt.GridLayout;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends JFrame{

    public static void main(String[] args) throws Exception{

        URL[] urls = { //when posting, always use web resources to make your code mcve
                new URL("https://findicons.com/files/icons/345/summer/128/cake.png"),
                new URL("http://icons.iconarchive.com/icons/atyourservice/service-categories/128/Sweets-icon.png"),
         };

        JFrame f = new JFrame("Shop");
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //JFrame content pane uses a BorderLayout by default.
        //to change it: 
        f.setLayout(new GridLayout(0,1)); 

        JPanel panel1 = new JPanel();// uses FlowLayout by default
        JCheckBox q1 = new JCheckBox("CAKE");
        panel1.add(q1);  //add components to the sub panel 
        ImageIcon icon1 = new ImageIcon(urls[0]);
        JLabel l1 = new JLabel(icon1);
        panel1.add(l1);
        f.add(panel1); //add sub panel to main panel 

        JPanel panel2 = new JPanel();
        JCheckBox q2 = new JCheckBox("ICE CREAM");
        panel2.add(q2);

        ImageIcon icon2 = new ImageIcon(urls[1]);
        JLabel l2 = new JLabel(icon2);
        panel2.add(l2);
        f.add(panel2);

        f.pack();
        f.setVisible(true);
    }
}