import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Test {

    public Test() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final DrawPanel drawPanel = new DrawPanel();

        drawPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                for (Ball b : drawPanel.getBalls()) {//iterate through each ball
                    if (b.getBounds().contains(me.getPoint())) {//get the ball bounds and check if mouse click was within its bounds
                        if (!b.isSelected()) {//check if ball has been clicked on
                            b.setSelected(true);
                        } else {
                            b.setSelected(false);
                        }
                        drawPanel.repaint();//so ball color change will be shown
                    }
                }

            }
        });

        JPanel controlPanel = new JPanel();

        JButton createBallButton = new JButton("Add ball");
        createBallButton.addActionListener(new ActionListener() {
            Random rand = new Random();
            private int counter = 1;

            public void actionPerformed(ActionEvent e) {

                int ballRadius = 10;
                int x = rand.nextInt(drawPanel.getWidth());
                int y = rand.nextInt(drawPanel.getHeight());

                //check that we dont go offscreen by subtarcting its radius unless its x and y are not bigger than radius
                if (y > ballRadius) {
                    y -= ballRadius;
                }
                if (x > ballRadius) {
                    x -= ballRadius;
                }

                drawPanel.addBall(new Ball(x, y, ballRadius, counter));//add ball to panel to be drawn
                counter++;//increase the ball number
            }
        });

        final JTextArea jtf = new JTextArea(5, 10);
        jtf.setEditable(false);
        JButton printSelectedBallButton = new JButton("Print selected balls");
        printSelectedBallButton.addActionListener(new ActionListener() {
            Random rand = new Random();
            private int counter = 1;

            public void actionPerformed(ActionEvent e) {
                jtf.setText("");
                for (Ball b : drawPanel.getBalls()) {
                    if (b.isSelected()) {
                        jtf.append("Selected: " + b.getNumber() + "\n");
                    }
                }

            }
        });

        controlPanel.add(createBallButton);
        controlPanel.add(printSelectedBallButton);
        JScrollPane jsp = new JScrollPane(jtf);
        controlPanel.add(jsp);

        frame.add(drawPanel);
        frame.add(controlPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test();
            }
        });
    }
}

class DrawPanel extends JPanel {

    ArrayList<Ball> balls = new ArrayList<>();

    public void addBall(Ball b) {
        balls.add(b);
        repaint();
    }

    public ArrayList<Ball> getBalls() {
        return balls;
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2d = (Graphics2D) grphcs;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (Ball ball : balls) {
            ball.draw(g2d);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }
}

class Ball {

    private Color color;
    private int x, y;
    private int radius;
    private final int number;
    private boolean selected;

    Ball(int x, int y, int radius, int counter) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.number = counter;
        selected = false;
        this.color = Color.RED;//default color of unselected ball
    }

    public void draw(Graphics2D g2d) {
        Color prevColor = g2d.getColor();
        g2d.drawString(number + "", x + radius, y + radius);//draw the number of ball
        g2d.setColor(color);
        g2d.fillOval(x, y, radius, radius);
        g2d.setColor(prevColor);
    }

    public Rectangle2D getBounds() {
        return new Rectangle2D.Double(x, y, radius, radius);
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        if (selected) {
            color = Color.GREEN;
        } else {
            color = Color.RED;
        }
    }

    boolean isSelected() {
        return selected;
    }

    int getNumber() {
        return number;
    }
}