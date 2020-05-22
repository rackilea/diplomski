import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class StackOverFlow {
    static String bet = "";
    public static void main(String[] args) {
        final JOptionPane pane = new JOptionPane();

        Timer t = new Timer(3000, new ActionListener() {
            public void actionPerformed(ActionEvent e ) {
                pane.getRootFrame().dispose();
            }
        });
        t.start();
        bet = pane.showInputDialog("give me a value");
        t.stop();

        if(bet == null) {
            bet = "30";
        }

        System.out.println(bet);
    }
}