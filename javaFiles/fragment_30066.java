import java.awt.EventQueue;
import javax.swing.JFrame;

public class SimpleExample extends JFrame {

    public SimpleExample() {

       setTitle("Simple example");
       setSize(300, 200);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);        
    }


    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleExample ex = new SimpleExample();
                ex.setVisible(true);
            }
        });
    }
}