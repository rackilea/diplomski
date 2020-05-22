package javaapplication765;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new BasePane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class BasePane extends JPanel {

        public BasePane() {
            setLayout(new BorderLayout());
            CardLayout cl = new CardLayout();
            JPanel mainView = new JPanel(cl);
            mainView.add(new JPanel(), "empty");
            mainView.add(new BananaPane(), "banana");
            add(mainView);

            JButton btn = new JButton("Fruit loop");
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cl.show(mainView, "banana");
                }
            });
            add(btn, BorderLayout.NORTH);
        }

    }

    public class BananaPane extends JPanel {

        public BananaPane() {
            setLayout(new BorderLayout());
            setBorder(new EmptyBorder(25, 25, 25, 25));
            add(new JLabel("I'm a banana"));
        }

    }

}