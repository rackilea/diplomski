import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


public class TestLine {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestLine().start();
            }
        });
    }

    private static void start() {
        JFrame frame = new JFrame();
        frame.setContentPane(new CarthPanel());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private static class CarthPanel extends JComponent {

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D gg = (Graphics2D) g;

//            System.out.println("(w,h)=(" + w + "," + h + ")");

            gg.translate(getWidth(), 0); // <<< when uncommenting both lines, mirroring applies
            gg.scale(-1.0, 1.0);    //

            BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);

            try {
                paintTest(img.createGraphics());
            } catch (Exception e) {
                e.printStackTrace();
            }

            g.drawImage(img, 0, 0, null);
        }



        private void paintTest(Graphics2D g) {
            // black background
            g.setColor(Color.black);
            g.fillRect(0, 0, getWidth(), getHeight());

            // colored corners
            g.setColor(Color.RED);
            g.drawLine(0, 0, 10, 0);
            g.drawLine(0, 0, 0, 10);
            g.setColor(Color.RED);
            g.drawLine(0, 199, 10, 199);
            g.drawLine(0, 199, 0, 189);
            g.setColor(Color.CYAN);
            g.drawLine(189, 0, 199, 0);
            g.drawLine(199, 0, 199, 10);
            g.setColor(Color.CYAN);
            g.drawLine(189, 199, 199, 199);
            g.drawLine(199, 199, 199, 189);

            // yellow squares
            g.setColor(Color.yellow);
            g.drawRect(3, 3, 10, 10);
            g.fillRect(186, 3, 11, 11);
            g.fillRect(3, 186, 11, 11);
            g.drawRect(186, 186, 10, 10);

            String chars = "ABC";
            g.setFont(Font.decode("Arial 72"));
            Rectangle2D rect = g.getFontMetrics().getStringBounds(chars, g);
            g.drawString(chars, (int) (200 - rect.getWidth()) / 2, (int) (200 - rect.getHeight()));
        }
    }
}