import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.BorderLayout;

public class PanelSwap {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PanelSwap().frame.setVisible(true);
            }
        });
    }

    JFrame frame;
    JPanel panel1;
    JPanel panel2;

    PanelSwap() {

        frame = new JFrame();
        frame.setLocationRelativeTo(null);

        panel1 = new JPanel(new BorderLayout());

        JButton toPanel2 = new JButton("Goto Panel 2");
        toPanel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(panel2);
                frame.validate();
            }
        });

        panel1.add(toPanel2, BorderLayout.CENTER);

        panel2 = new JPanel(new BorderLayout());

        JButton toPanel1 = new JButton("Goto Panel 1");
        toPanel1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(panel1);
                frame.validate();
            }
        });

        panel2.add(toPanel1, BorderLayout.CENTER);

        frame.setContentPane(panel1);
        frame.pack();
    }
}