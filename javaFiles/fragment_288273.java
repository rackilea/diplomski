import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Resize {

    Resize(){


    final JFrame frame = new JFrame();
    frame.setBounds(100, 50, 500, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.getContentPane().setBackground(Color.white);


    frame.setVisible(true);
    ActionListener al = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if(frame.getSize().width <250 || frame.getSize().height <350)
            {
                JOptionPane.showMessageDialog(null, "Size cannot be smaller than 250,350"); 
                frame.setSize(500, 500);
            }
        }
    };

    Timer t = new Timer(1000, al);
    t.start();

    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Resize();
    }

}