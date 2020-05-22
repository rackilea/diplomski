package swing;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClearLayeredPanelsGUI extends JFrame {
    Action clearRect;
    Action drawRect;
    Action clearRound;
    Action drawRound;

    TransparentBoard rectBoard;
    TransparentBoard roundBoard;
    JPanel whiteBackground;

    JPanel stack;
    JPanel buttonBar;

    public ClearLayeredPanelsGUI() {
        initPanels();
    }

    private void initPanels() {
        initStackPanel();
        initButtonPanel();

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(stack, BorderLayout.CENTER);
        this.getContentPane().add(buttonBar, BorderLayout.NORTH);
    }

    private void initStackPanel() {
        stack = new JPanel(new StackLayout());
        stack.setPreferredSize(new Dimension(300, 300));

        whiteBackground = new JPanel();
        whiteBackground.setOpaque(true);
        whiteBackground.setBackground(Color.WHITE);

        rectBoard = new TransparentBoard(Color.BLUE, new Rectangle(0, 0, 100, 200));
        roundBoard = new TransparentBoard(Color.RED, new Ellipse2D.Float(0.0f, 0.0f, 150.0f, 100.0f));


        stack.add(whiteBackground, StackLayout.TOP);
        stack.add(roundBoard, StackLayout.TOP);
        stack.add(rectBoard, StackLayout.TOP);

        stack.setOpaque(false);
    }

    private void initButtonPanel() {
        buttonBar = new JPanel(new FlowLayout());

        buttonBar.add(new JButton(new ClearAction("Clear Rect", rectBoard)));
        buttonBar.add(new JButton(new DrawAction("Draw Rect", rectBoard)));
        buttonBar.add(new JButton(new ClearAction("Clear Ellipse", roundBoard)));
        buttonBar.add(new JButton(new DrawAction("Draw Ellipse", roundBoard)));
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        ClearLayeredPanelsGUI f = new ClearLayeredPanelsGUI();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Stack of transparent panes with Clear");
//        f.pack();
        f.setSize(new Dimension(500,350));
        f.setVisible(true);
    }

    private class DrawAction extends AbstractAction {
        private TransparentBoard board;
        public DrawAction(String txt, TransparentBoard b) {
            super(txt);
            this.board = b;
        }
        public void actionPerformed(ActionEvent e) {
            board.drawShape();
            stack.repaint();
        }
    }

    private class ClearAction extends AbstractAction {
        private TransparentBoard board;
        public ClearAction(String txt, TransparentBoard b) {
            super(txt);
            this.board = b;
        }
        public void actionPerformed(ActionEvent e) {
            board.clearShape();
            stack.repaint();
        }
    }

    private class TransparentBoard extends JComponent {
        BufferedImage board = new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB);
        Dimension d = new Dimension(300,300);

        private Color paintColor;
        private Shape shape;

        public TransparentBoard(Color color, Shape s) {
            setOpaque(false);
            Graphics2D g2d = (Graphics2D) board.getGraphics();
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR));
            g2d.fillRect(0,0,board.getWidth(),board.getHeight());

            this.paintColor = color;
            this.shape = s;

            clearShape();
            drawShape();
        }

        public void drawShape() {
            Graphics2D g2d = (Graphics2D) board.getGraphics();
            g2d.translate(50, 50);
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2.0f));
            g2d.draw(shape);
            g2d.setColor(paintColor);
            g2d.fill(shape);

            repaint();
        }

        public void clearShape() {
            Graphics2D g2d = (Graphics2D) board.getGraphics();
            Composite oldComposite = g2d.getComposite();
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR));
            g2d.fillRect(0,0,board.getWidth(),board.getHeight());
            //reset alpha composite
            g2d.setComposite(oldComposite);
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (board != null) {
                Graphics2D g2d = (Graphics2D) g.create();

                try {
                    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
                    g2d.drawImage(board, 0, 0, board.getWidth(), board.getHeight(), null);
                } finally {
                    g2d.dispose();
                }
            }
        }
    }
}