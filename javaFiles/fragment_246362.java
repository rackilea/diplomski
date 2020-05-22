import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class OptionPaneTest {

    public static void main(String[] args) {
        new OptionPaneTest();
    }

    public OptionPaneTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                StringBuilder sb = new StringBuilder(128);
                sb.append("<html><b><p align=center>You won't get away with this!</p></b><br>");
                sb.append("Alert! Alert! A chocy nut bar has been removed without payment!");
                sb.append("<br>A chocy nut bar... has been REMOVED! WITHOUT PAYMENT! Alert, alert!");

                JOptionPane.showMessageDialog(null, sb.toString(), "Alert", JOptionPane.WARNING_MESSAGE);

            }
        });
    }        
}