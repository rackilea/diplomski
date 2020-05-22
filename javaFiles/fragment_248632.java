import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class csView extends JPanel {
    // Declare those variables here
    String hhhhh;
    JLabel Uniqlbl;

    public csView() {
        setLayout(null);

        Uniqlbl = new JLabel("Cashier Name:");
        Uniqlbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Uniqlbl.setBounds(227, 62, 253, 46);
        add(Uniqlbl);

    }

    // Add a setter here
    public void setHhhhh(String hhhhh) {
        this.hhhhh = hhhhh;
        // Edit: Add this line to update the Uniqlbl text
        Uniqlbl.setText(hhhhh);
    }
}