import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MultiDialog {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        final JDialog d1 = new JDialog();
                        final JDialog d2 = new JDialog(d1);
                        d1.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
                        d2.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

                        d1.setSize(new Dimension(150, 100));
                        d1.setTitle("Parent");
                        d1.setLocation(50, 50);

                        d2.setTitle("Child");
                        d2.setSize(new Dimension(100, 100));
                        d2.setLocation(150, 150);

                        JFrame f = new JFrame("App");
                        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        JButton b1 = new JButton("Show Parent Dialog");
                        f.add(b1);
                        b1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                d1.setVisible(true);
                            }
                        });

                        d1.addWindowListener(new WindowAdapter(){
                            @Override
                            public void windowClosing(WindowEvent arg0) {
                                d2.setVisible(false);
                            };
                        });

                        JButton b2 = new JButton("Show Child Dialog");
                        d1.add(b2);
                        b2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                d2.setVisible(true);
                            }
                        });

                        f.pack();
                        f.setVisible(true);
                    }
                }
                );
    }
}