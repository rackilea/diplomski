import java.awt.Color;
import javax.swing.JPanel;

public class NewClass1 extends javax.swing.JFrame 
{
    public NewClass1() {            
         setLayout(null);
         JPanel panel=new JPanel();
         panel.setOpaque(true);
         add(panel);
         panel.setBackground(Color.red);
         panel.setBounds(0,0,400,300);
    }    

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewClass1().setVisible(true);
            }
        });
    }
}