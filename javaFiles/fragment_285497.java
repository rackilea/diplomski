import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Splash extends JWindow{
    int duration;

    public Splash(int duration) {
        this.duration = duration;

        showSplash();
    }

    public void showSplash() {

        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        Timer timer = new Timer(duration, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                System.exit(0);
            }
        });
        timer.start();

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                Splash splash = new Splash(5000);
            }   
        });
    }
}