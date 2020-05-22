import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class HelloJava4b extends JPanel {
    // don't have component class implement listener interfaces
    private static final int PREF_W = 400;
    private static final int PREF_H = PREF_W;
    public static final Color[] COLORS = { Color.black, Color.red, Color.green, Color.blue,
            Color.magenta };
    private static final int TIMER_DELAY = 300;
    private static final Font TEXT_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 40);
    private int colorsIndex = 0;
    private boolean blinkState = false;
    private String text;
    private int messageX = 125;
    private int messageY = 95;

    public HelloJava4b(String text) {
        this.text = text;
        add(new JButton(new ButtonAction("Change Color")));

        // create Swing Timer and start
        new Timer(TIMER_DELAY, new TimerListener()).start();

        // create mouse listener and add
        MyMouse myMouse = new MyMouse();
        addMouseListener(myMouse);
        addMouseMotionListener(myMouse);
    }

    // size component per its preferred size
    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color c = blinkState ? getBackground() : COLORS[colorsIndex];
        g.setColor(c);

        // make rendering smoother
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setFont(TEXT_FONT);  // and bigger
        g.drawString(text, messageX, messageY);
    }

    // button's Action
    private class ButtonAction extends AbstractAction {
        public ButtonAction(String name) {
            super(name);
            int mnemonic = (int) name.charAt(0);
            putValue(MNEMONIC_KEY, mnemonic); // alt-char hot key
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            colorsIndex++;
            colorsIndex %= COLORS.length;
        }
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            blinkState = !blinkState;
            repaint();
        }
    }

    // my combination mouse listener and motion listener
    private class MyMouse extends MouseAdapter {
        private boolean moving = false;

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() != MouseEvent.BUTTON1) {
                return;
            }
            moving = true;
            messageX = e.getX();
            messageY = e.getY();
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // if not moving, then right button not pressed
            if (moving) {
                messageX = e.getX();
                messageY = e.getY();
                repaint();
                moving = false;
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (moving) {
                messageX = e.getX();
                messageY = e.getY();
                repaint();
            }
        }
    }

    private static void createAndShowGui() {
        HelloJava4b mainPanel = new HelloJava4b("Hello All!");

        JFrame frame = new JFrame("Hello Java");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}