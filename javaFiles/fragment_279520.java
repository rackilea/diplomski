import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * This example requires iText. I retrieved it from Maven repository
 * 
 *      <dependency>
 *          <groupId>com.itextpdf</groupId>
 *          <artifactId>itextpdf</artifactId>
 *          <version>5.5.2</version>
 *      </dependency>
 *
 * The program can be run without iText if you comment out the entire
 * method printToPDF (and iText imports), along with it's method call in 
 * the class constructor. The result will be the the image above.
 */

public class LargePanelToImageMCVE {

    public LargePanelToImageMCVE() {
        LargeImagePanel panel = new LargeImagePanel();
        JFrame frame = new JFrame();
        frame.add(new JScrollPane(panel));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);

        final java.awt.Image image = getImageFromPanel(panel);

        /* This was just a text panel to make sure the full panel was
         * drawn to the panel.
         */
        JPanel newPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(300, 300);
            }
        };

        /* Print Image to PDF */
        String fileName = "D://newfile.pdf";
        printToPDF(image, fileName);

        /* This was just a test to show the newPanel drew the entire
         * original panel (scaled)
         */
        JOptionPane.showMessageDialog(null, newPanel);

    }

    public void printToPDF(java.awt.Image awtImage, String fileName) {
        try {
            Document d = new Document();
            PdfWriter writer = PdfWriter.getInstance(d, new FileOutputStream(
                    fileName));
            d.open();


            Image iTextImage = Image.getInstance(writer, awtImage, 1);
            iTextImage.setAbsolutePosition(50, 50);
            iTextImage.scalePercent(25);
            d.add(iTextImage);

            d.close();

        } catch (Exception e) {
            e.printStackTrace();
        }   
    }

    public static java.awt.Image getImageFromPanel(Component component) {

        BufferedImage image = new BufferedImage(component.getWidth(),
                component.getHeight(), BufferedImage.TYPE_INT_RGB);
        component.paint(image.getGraphics());
        return image;
    }

    /**
     * Demo panel that is 2000x2000 px with alternating squares
     * to check all squares are drawn to image
     */
    public class LargeImagePanel extends JPanel {
        private static final int FULL_SIZE = 2000;
        private static final int PER_ROW_COLUMN = 20;
        private static final int SQUARE_SIZE = FULL_SIZE / PER_ROW_COLUMN;

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int row = 0; row < PER_ROW_COLUMN; row++) {
                for (int col = 0; col < PER_ROW_COLUMN; col++) {
                    if ((row % 2) == (col % 2)) {
                        g.setColor(Color.BLACK);
                    } else {
                        g.setColor(Color.WHITE);
                    }
                    g.fillRect(col * SQUARE_SIZE, row * SQUARE_SIZE,
                            SQUARE_SIZE, SQUARE_SIZE);
                }
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(FULL_SIZE, FULL_SIZE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LargePanelToImageMCVE();
            }
        });
    }
}