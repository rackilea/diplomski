import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
public class Main {
    public static void main(String[] arg) {

        int delay =1000;
        Timer timer = new Timer(delay , new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) 
           {
               update();
               repaint();  
           }

           private void repaint() {
             // Do repainttask          
           }

           private void update() {
              //  Do update task            
           }  

       });

    }