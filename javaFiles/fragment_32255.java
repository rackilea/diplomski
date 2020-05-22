import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class TestClass {

    public static void main(String[] args)
    {
        errorpopup(new Exception("Error"));
    }

    private static void errorpopup(Exception m)
    {
        JLabel messageLabel = new JLabel("<html><body><p style='width: 300px;'>"+m.toString()+"</p></body></html>");
        Timer timer = new Timer(10000, 
            new ActionListener()
            {   
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    SwingUtilities.getWindowAncestor(messageLabel).dispose();
                }
            });
        timer.setRepeats(false);
        timer.start();
        JOptionPane.showMessageDialog(null, messageLabel, "Error Window Title", JOptionPane.ERROR_MESSAGE);
    }
}