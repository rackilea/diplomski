import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.*;

@SuppressWarnings("serial")
public class TestDrawingCanvas extends JPanel {
    private DrawingCanvas drawingCanvas = new DrawingCanvas();

    public TestDrawingCanvas() {
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        btnPanel.add(new JButton(new ClearAction()));

        setLayout(new BorderLayout());
        add(drawingCanvas, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.PAGE_END);
    }

    private class ClearAction extends AbstractAction {
        public ClearAction() {
            super("Clear Canvas");
            putValue(MNEMONIC_KEY, KeyEvent.VK_C);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            drawingCanvas.clear();
        }
    }

    private static void createAndShowGui() {
        TestDrawingCanvas mainPanel = new TestDrawingCanvas();

        JFrame frame = new JFrame("Drawing Canvas");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}

@SuppressWarnings("serial")
class DrawingCanvas extends JPanel {
    private static final int PREF_W = 800;
    private static final int PREF_H = 600;
    public static final Color LINE_COLOR = Color.YELLOW;
    public static final Stroke IMG_STROKE = new BasicStroke(10f);
    private Color lineColor = LINE_COLOR;
    private BufferedImage image;

    public DrawingCanvas() {
        setBackground(Color.WHITE);
        image = new BufferedImage(PREF_W, PREF_H, BufferedImage.TYPE_INT_ARGB);
        MyMouse myMouse = new MyMouse();
        addMouseListener(myMouse);
        addMouseMotionListener(myMouse);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    public void clear () {
        image = new BufferedImage(PREF_W, PREF_H, BufferedImage.TYPE_INT_ARGB);
        repaint();
    }

    private class MyMouse extends MouseAdapter {
        private Graphics2D imgG2d;
        private Point p1;

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() != MouseEvent.BUTTON1) {
                return;
            }

            imgG2d = image.createGraphics();
            imgG2d.setColor(lineColor);
            imgG2d.setStroke(IMG_STROKE);
            p1 = e.getPoint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            drawLine(e);
            imgG2d.dispose();
            p1 = null;
            imgG2d = null;
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            drawLine(e);
            p1 = e.getPoint();
        }

        private void drawLine(MouseEvent e) {
            if (imgG2d == null || p1 == null) {
                return;
            }
            Point p2 = e.getPoint();
            int x1 = p1.x;
            int y1 = p1.y;
            int x2 = p2.x;
            int y2 = p2.y;
            imgG2d.drawLine(x1, y1, x2, y2);
            repaint();
        }
    }
}