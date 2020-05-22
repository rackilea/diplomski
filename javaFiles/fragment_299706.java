import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Demo extends JFrame {

    public static void main(String[] args) {
        Demo frame = new Demo();
        frame.setVisible(true);
    }

    public Demo() throws HeadlessException {
        super();
        init();
    }

    private void init() {
        Point start = new Point(0, 0);
        Paddle paddle = new Paddle(start, 20, 20);
        DrawingPanel drawingPanel = new DrawingPanel(paddle);
        setContentPane(drawingPanel);
        pack();
    }

    class DrawingPanel extends JPanel implements MouseMotionListener {

        private Paddle paddle;

        public DrawingPanel(Paddle paddle) {
            super();
            this.paddle = paddle;
            this.addMouseMotionListener(this);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.fillRect(paddle.point.x, paddle.point.y, paddle.width, paddle.height);
        }

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            paddle.point = new Point(e.getX(), e.getY());
            repaint();
        }

    }

    class Paddle {
        Point point;
        Integer height, width;

        public Paddle(Point point, Integer height, Integer width) {
            super();
            this.point = point;
            this.height = height;
            this.width = width;
        }
    }
}