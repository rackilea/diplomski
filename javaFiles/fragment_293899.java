import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new BorderLayout());
            GamePane gamePane = new GamePane();
            JSlider slider = new JSlider(25, 10000);
            add(gamePane);
            add(slider, BorderLayout.SOUTH);

            slider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    gamePane.setActiveEntityCount(slider.getValue());
                }
            });

            slider.setValue(25);
        }

    }

    public class GamePane extends JPanel {

        private List<MovableEntity> poolOfEntities;
        private List<MovableEntity> activeEntities;

        private int activeCount;

        private int growthRate = 100;

        public GamePane() {
            poolOfEntities = new ArrayList<>(25);
            activeEntities = new ArrayList<>(25);

            setFont(getFont().deriveFont(Font.BOLD, 48f));

            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    Iterator<MovableEntity> it = activeEntities.iterator();
                    while (it.hasNext()) {

                        MovableEntity entity = it.next();
                        if (entity.update(getWidth(), getHeight())) {

                            it.remove();
                            // This drop objects if the total number of objects exceeds the activeCount
                            if (poolOfEntities.size() + activeEntities.size() < activeCount) {
                                poolOfEntities.add(entity);
                            }

                        }

                    }

                    for (int growth = 0; growth < growthRate && activeEntities.size() < activeCount; growth++) {

                        MovableEntity entity = null;
                        if (poolOfEntities.isEmpty()) {

                            entity = createNewEntity();

                        } else {

                            entity = poolOfEntities.remove(0);

                        }
                        activeEntities.add(entity);

                    }

                    repaint();

                }
            });
            timer.start();
        }

        protected MovableEntity createNewEntity() {

            int width = getWidth();
            int height = getHeight();
            if (width == 0) {
                width = getPreferredSize().width;
            } else if (height == 0) {
                height = getPreferredSize().height;
            }

            return new ShapeEntity(width, height);

        }

        public void setActiveEntityCount(int count) {

            if (count != activeCount) {

                activeCount = count;

            }

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            Iterator<MovableEntity> it = activeEntities.iterator();
            while (it.hasNext()) {
                MovableEntity entity = it.next();
                entity.paint(g2d);
            }

            String text = Integer.toString(activeEntities.size());
            FontMetrics fm = g2d.getFontMetrics();
            int x = getWidth() - fm.stringWidth(text);
            int y = (getHeight() - fm.getHeight() )+ fm.getAscent();

            g2d.setColor(Color.WHITE);
            g2d.drawString(text, x, y);

            g2d.dispose();
        }

    }

    public interface Entity {

        public void paint(Graphics2D g);

    }

    public interface MovableEntity extends Entity {

        public boolean update(int width, int height);

    }

    public static class ShapeEntity implements MovableEntity {

        protected static final Color COLORS[] = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
        protected static final Random RND = new Random();

        private Rectangle bounds;
        private final Color color = COLORS[RND.nextInt(COLORS.length)];
        private int xDelta;

        public ShapeEntity(int width, int height) {

            reset(width, height);

        }

        protected void reset(int width, int height) {

            bounds = new Rectangle();

            bounds.width = 5 + RND.nextInt(25);
            bounds.height = 5 + RND.nextInt(25);

            bounds.x = -bounds.width; // offscreen
            bounds.y = RND.nextInt(height - bounds.height);

            xDelta = 1 + RND.nextInt(8);

        }

        @Override
        public boolean update(int width, int height) {

            boolean reset = false;
            bounds.x += xDelta;
            if (bounds.x > width) {
                reset(width, height);
                reset = true;
            }

            return reset;

        }

        @Override
        public void paint(Graphics2D g) {

            g.setColor(color);
            g.fill(bounds);

        }

    }

}