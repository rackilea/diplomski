import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Main {

    public static void main(String args[]){
        final ActionListener action = new ActionListener(){
            public void actionPerformed(final ActionEvent e){
                for(int i = 0; i <= 1000; i++)
                    System.out.printf("%d\n", i);
            }
        };
        final Timer timer = new Timer(1000, action);
        timer.start();
    }
}