import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static enum Direction {
        LEFT(-1), RIGHT(1);

        private int delta;

        private Direction(int delta) {
            this.delta = delta;
        }

        public int getDelta() {
            return delta;
        }

    }

    public static class TestPane extends JPanel {

        private int xPos = 95;

        private Set<Direction> movement = new TreeSet<>();

        public TestPane() {
            final InputMap im = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
            final ActionMap am = getActionMap();

            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0, true), "Release.left");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "Release.left");

            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "Release.right");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "Release.right");

            am.put("Release.left", new ReleaseAction(movement, Direction.LEFT));
            am.put("Release.right", new ReleaseAction(movement, Direction.RIGHT));

            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false), "Press.right");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "Press.right");
            am.put("Press.right", new PressAction(movement, Direction.RIGHT));

            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0, false), "Press.left");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "Press.left");
            am.put("Press.left", new PressAction(movement, Direction.LEFT));

            Timer timer = new Timer(5, e -> {
                for (Direction dir :  movement) {
                    xPos += dir.getDelta();
                }
                repaint();
            });
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.RED);
            g2d.fillRect(xPos, 95, 10, 10);
            g2d.dispose();
        }

    }

    private static final Instant ANCHOR = Instant.now();
    private static Instant switchAd = Instant.now();

    protected static long switchDelay() {
        return Duration.between(switchAd, Instant.now()).toMillis();
    }

    protected static long tick() {
        return Duration.between(ANCHOR, Instant.now()).toMillis();
    }

    static public class PressAction extends AbstractAction {

        private final Set<Direction> movement;
        private final Direction value;

        public PressAction(Set<Direction> movementState, Direction value) {
            this.movement = movementState;
            this.value = value;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            movement.add(value);
        }
    }
    static public class ReleaseAction extends AbstractAction {

        private final Set<Direction> movement;
        private final Direction value;

        public ReleaseAction(Set<Direction> movementState, Direction value) {
            this.movement = movementState;
            this.value = value;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            movement.remove(value);
        }
    }

}