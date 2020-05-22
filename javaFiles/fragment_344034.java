import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.*;

@SuppressWarnings("serial")
public class MyPanel extends JPanel {
    private static final int PREF_W = 400;
    private static final int PREF_H = PREF_W;
    private int cols;
    private int rows;
    private static final Color BG = Color.BLACK;
    private static final int GAP = 1;
    private BufferedImage img;
    private int rectWidth;
    private int rectHeight;

    public MyPanel(int rows, int cols) {
        this.cols = cols;
        this.rows = rows;
        img = createMyImage();
    }

    public void specificPaint(int coordinateX, int coordinateY, Color color) {
        Graphics g = img.getGraphics(); // get img's Graphics object
        int x = coordinateX * this.rectWidth + GAP;
        int y = coordinateY * this.rectHeight + GAP;
        g.setColor(color);
        g.fillRect(x, y, rectWidth - 2 * GAP, rectWidth - 2 * GAP);
        g.dispose();
        repaint();
    }

    private BufferedImage createMyImage() {
        img = new BufferedImage(PREF_W, PREF_H, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setBackground(BG);
        g2.clearRect(0, 0, img.getWidth(), img.getHeight());
        this.rectWidth = img.getWidth() / cols;
        this.rectHeight = img.getHeight() / rows;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int x = i * this.rectWidth + GAP;
                int y = j * this.rectHeight + GAP;
                g2.setColor(Color.WHITE);
                g2.fillRect(x, y, this.rectWidth - 2 * GAP, this.rectHeight - 2 * GAP);
            }
        }
        g2.dispose();
        return img;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            g.drawImage(img, 0, 0, this);
        }

        // if you need to draw changing non-static images, do it here
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet() || img == null) {
            return super.getPreferredSize();
        }
        int w = img.getWidth();
        int h = img.getHeight();
        return new Dimension(w, h);
    }

    private static void createAndShowGui() {
        MyPanel modelMap = new MyPanel(50, 50);
        JFrame frame = new JFrame("MyPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(modelMap);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        modelMap.specificPaint( 40,40,Color.RED );
        modelMap.specificPaint( 10,10,Color.RED );
        modelMap.specificPaint( 20,25,Color.BLUE );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}