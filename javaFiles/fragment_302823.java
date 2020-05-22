import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SimpleJoystickDemo extends JFrame {

    //I think that orginally made by @HFOE    

    private int displayWidth = 340;
    private int displayHeight = 550;
    private final Point position;

    public SimpleJoystickDemo() {
        super("SimpleJoystickDemo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(displayWidth, displayHeight);
        setLocationRelativeTo(null);
        position = new Point();
        SimpleJoystick myJoystick = new SimpleJoystick(150, position, 100);
        add(myJoystick, BorderLayout.PAGE_END);
        Drawing drawing = new Drawing(position);
        add(drawing);
    }

    public static void main(final String[] args) {
        Runnable gui = new Runnable() {
            @Override
            public void run() {
                new SimpleJoystickDemo().setVisible(true);
            }
        };
        SwingUtilities.invokeLater(gui);
    }

    private class Drawing extends JPanel {

        private static final long serialVersionUID = 1L;
        private final Point position;

        public Drawing(Point position) {
            this.position = position;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.RED);
            g2.fillOval(160 + position.x, 160 - position.y, 15, 15);
        }
    }
}

class SimpleJoystick extends JPanel {

    private static final long serialVersionUID = 1L;
    //Maximum value for full horiz or vert position where centered is 0:
    private int joyOutputRange;
    private float joySize;     //joystick icon size
    private float joyWidth, joyHeight;
    private float joyCenterX, joyCenterY;  //Joystick displayed Center
    //Display positions for text feedback values:
    private int textHorizPos, textVertPos;
    private int fontSpace = 12;
    private float curJoyAngle;    //Current joystick angle
    private float curJoySize;     //Current joystick size
    private boolean isMouseTracking;
    private boolean leftMouseButton;
    private int mouseX, mouseY;
    private Stroke lineStroke = new BasicStroke(10, BasicStroke.CAP_ROUND,
            BasicStroke.JOIN_ROUND);
    private final Point position;

    public SimpleJoystick(final int joyOutputRange,
            final Point position, final int joySize) {
        this.joyOutputRange = joyOutputRange;
        this.position = position;
        this.joySize = joySize;
        joyWidth = joySize;
        joyHeight = joyWidth;
        setPreferredSize(new Dimension((int) joyWidth + 250,
                (int) joyHeight + 80));
        joyCenterX = getPreferredSize().width / 2;
        joyCenterY = getPreferredSize().height / 2;
        this.joySize = joyWidth / 2;
        setBackground(new Color(226, 226, 226));
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseMoved(final MouseEvent e) {
                mouseCheck(e);
            }

            @Override
            public void mousePressed(final MouseEvent e) {
                leftMouseButton = SwingUtilities.isLeftMouseButton(e);
                mouseCheck(e);
            }
        };
        addMouseMotionListener(mouseAdapter);
        addMouseListener(mouseAdapter);
    }

    private void mouseCheck(final MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        float dx = mouseX - joyCenterX;
        float dy = mouseY - joyCenterY;
        if (leftMouseButton) {
            isMouseTracking = true;
        } else {
            isMouseTracking = false;
        }
        if (isMouseTracking) {
            curJoyAngle = (float) Math.atan2(dy, dx);
            curJoySize = (float) Point.distance(mouseX, mouseY,
                    joyCenterX, joyCenterY);
        } else {
            curJoySize = 0;
        }
        if (curJoySize > joySize) {
            curJoySize = joySize;
        }
        position.x = (int) (joyOutputRange * (Math.cos(curJoyAngle)
                * curJoySize) / joySize);
        position.y = (int) (joyOutputRange * (-(Math.sin(curJoyAngle)
                * curJoySize) / joySize));
        SwingUtilities.getRoot(SimpleJoystick.this).repaint();
    }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.LIGHT_GRAY);
        g2.fillOval((int) (joyCenterX - joyWidth / 2),
                (int) (joyCenterY - joyHeight / 2),
                (int) joyWidth, (int) joyHeight);
        //rotate and draw joystick line segment:
        Graphics2D g3 = (Graphics2D) g2.create();
        g3.translate(joyCenterX, joyCenterY);
        g3.rotate(curJoyAngle);
        g3.setColor(Color.GRAY);
        g3.setStroke(lineStroke);
        g3.drawLine(0, 0, (int) curJoySize, 0);
        g3.dispose();
        //
        g2.setColor(Color.GRAY);
        g2.fillOval((int) joyCenterX - 10, (int) joyCenterY - 10, 20, 20);
        textHorizPos = 50;
        textVertPos = (int) (joyCenterY - 50);
        g2.drawString("Horizont:", textHorizPos, textVertPos);
        textHorizPos += (4 * fontSpace);
        g2.drawString(String.valueOf(position.x), textHorizPos, textVertPos);
        textHorizPos = 50;
        textVertPos += 12;
        g2.drawString("Vertical :", textHorizPos, textVertPos);
        textHorizPos += (4 * fontSpace);
        g2.drawString(String.valueOf(position.y), textHorizPos, textVertPos);
    }
}