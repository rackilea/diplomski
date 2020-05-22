import java.awt.*;
import javax.swing.*;

public class JXLabelTest {

    public static void main(String[] args) {
        Runnable r = () -> {
            String s = "The quick brown fox jumps over the lazy dog";
            JLabel myLabel = new JLabel(s);
            myLabel.setFont(new Font("Segoe UI", Font.PLAIN, 6));
            JOptionPane.showMessageDialog(null, myLabel);
            JOptionPane.showMessageDialog(null, new JXLabel(s));
        };
        SwingUtilities.invokeLater(r);
    }
}

class JXLabel extends JLabel {

    Font f = new Font("Segoe UI", Font.PLAIN, 6);

    public JXLabel() {    
        super();
        this.setFont(f);
    }  

    public JXLabel(Icon icon) {
        super(icon);
        this.setFont(f);
    }  

    public JXLabel(Icon icon, int horizontalAlignment) {
        super(icon, horizontalAlignment);
        this.setFont(f);
    }  

    public JXLabel(String text) {
        super(text);
        this.setFont(f);
    }  

    public JXLabel(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
        this.setFont(f);
    }  

    public JXLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
        this.setFont(f);
    }  
}