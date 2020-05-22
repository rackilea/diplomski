import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ShadowedFrame extends JFrame {

    ShadowedFrame() {
        super("Shadowed Frame");
        getRootPane().setGlassPane(new JComponent() {
            public void paintComponent(Graphics g) {
                g.setColor(new Color(0, 0, 0, 100));
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        });
        JButton popDialog = new JButton("Block Frame");
        popDialog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                getRootPane().getGlassPane().setVisible(true);
                JOptionPane.showMessageDialog(ShadowedFrame.this, "Shady!");
                getRootPane().getGlassPane().setVisible(false);
            }
        });
        setContentPane(popDialog);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setSize(350,180);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ShadowedFrame().setVisible(true);
            }
        });
    }
}