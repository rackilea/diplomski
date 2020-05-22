import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Test {   
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer(10,new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                updateProjectilePositions();
            }

        });
        timer.start(); 
    }

    private static void updateProjectilePositions() {
        // TODO Auto-generated method stub
    }
}