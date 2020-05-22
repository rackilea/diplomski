import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class TimerDemo extends JFrame {

    private static final long serialVersionUID = 1L;
    private javax.swing.Timer timer;

    public TimerDemo() {
        super("Panel Timer Demo");
        //initialing swing timer
        timer = new javax.swing.Timer(100, getButtonAction());
        JPanel p = new JPanel ();
        p.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent ev){
                timer.start();
            }
            @Override
            public void mouseExited(MouseEvent ev){
                timer.stop();
                }
            });

          p.setBackground(Color.blue);

          getContentPane().add(p,BorderLayout.CENTER);
          setDefaultCloseOperation(3);
          setLocationRelativeTo(null);
          pack();
    }

    private ActionListener getButtonAction() {
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Heloo");
            }
        };
        return action;
    }

    public static void main(String... args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TimerDemo().setVisible(true);
            }
        });
    }
}