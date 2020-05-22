package problemshowcase;

import java.awt.event.*;
import javax.swing.*;

public class ProblemShowcase {
    JFrame frame1 = null;
    JButton btn = null;

    public static void main(String[] args) {
        ProblemShowcase test = new ProblemShowcase();
        test.makeFrame();
    }

    public void makeFrame()
    {
        frame1 = new JFrame();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(500,500);

        btn = new JButton();
        btn.setDisabledIcon(new ImageIcon(getClass().getResource("/test.png")));
        btn.addActionListener(new someListener());

        frame1.getContentPane().add(btn);
        frame1.setVisible(true);
    }

    class someListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            JButton foo = (JButton) ev.getSource();
            btn.setIcon(new ImageIcon(getClass().getResource("/test.png")));

            foo.setEnabled(false);
        }
    }
}