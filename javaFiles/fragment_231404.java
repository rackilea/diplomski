import java.awt.*;
import javax.swing.*;

public class Test {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                final Image image = new ImageIcon(Test.class
                        .getResource("/resources/images/stackoverflow.png"))
                        .getImage();
                final BasicStroke stroke = new BasicStroke(5f);
                JPanel panel = new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        Graphics2D g2 = (Graphics2D) g;
                        g2.setStroke(stroke);
                        g2.drawLine(10, 75, 290, 75);
                        for (int x = 10; x < 300; x += 50) {
                            g2.drawImage(image, x, 59, this);
                        }
                    }

                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(300, 150);
                    }
                };

                JOptionPane.showMessageDialog(null, panel, "Line With Images",
                        JOptionPane.PLAIN_MESSAGE);
            }
        });
    }
}