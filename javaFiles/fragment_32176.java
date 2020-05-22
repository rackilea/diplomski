import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.*;
import java.awt.*;

public class Demo {

    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                render("Window");
            }
        });
    }

    public static void render(String s){
        JFrame f = new JFrame("Smile");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Pane pan = new Pane();
        f.add(pan);
        f.setSize(300,300);
        f.setVisible(true);
    }
}

    class Pane extends JPanel implements ActionListener {

        Pane(){
            setLayout(new GridLayout(4, 4, 3, 3));
            JButton l = null;
            for (int i = 1; i < 17; i++) {
                l = new JButton(""+i);
                l.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
                l.addActionListener(this);
                l.setSize(53,53);
                add(l);
            }
        }

    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton)(e.getSource());
        String i = b.getText();
        b.setIcon(new ImageIcon("u"+i+".jpg"));
    }
    }