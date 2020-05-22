import javax.swing.*;
import java.awt.event.*;

public class EventHandling1  {

    JButton jb;

    public static void main(String[] args) {
        EventHandling1 eh = new EventHandling1();
        eh.go();
    }

    public void go() {
        JFrame jf = new JFrame();
        jb = new JButton("New button");
        jb.addActionListener(new MyEventHandler());

        jf.getContentPane().add(jb);
        jf.setVisible(true);
        jf.setSize(700, 500);
    }

    private class MyEventHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            jb.setText("Pressed!!");
        }
    }
}