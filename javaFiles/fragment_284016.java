import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ColorFrame extends JFrame {
    private JPanel innerPanel = new JPanel();

    public static void main(String[] args) {
        new ColorFrame().setVisible(true);
    }

    public ColorFrame() {
        this.add(innerPanel);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new Thread() {
            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(1000);
                    } catch(Exception ex) {
                        break;
                    }
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            int r = (int)(255 * Math.random());
                            int g = (int)(255 * Math.random());
                            int b = (int)(255 * Math.random());
                            ColorFrame.this.innerPanel.setBackground(new Color(r, g, b));
                        }
                    });
                }
            }
        }.start();
    }
}