import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class WizardFireball {

    public static void main(String[] args) {
        new WizardFireball();
    }

    public WizardFireball() {
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
                frame.add(new GamePane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class GamePane extends JPanel {

        private GameModel model;

        public GamePane() {
            try {
                model = new DefaultModel();

                ActionMap am = getActionMap();
                InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);

                im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "up-pressed");
                im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "down-pressed");
                im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "left-pressed");
                im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "right-pressed");
                im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "up-released");
                im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "down-released");
                im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "left-released");
                im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "right-released");
                im.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "fire");

                am.put("up-pressed", new KeyPressedAction(getModel(), Key.UP));
                am.put("down-pressed", new KeyPressedAction(getModel(), Key.DOWN));
                am.put("left-pressed", new KeyPressedAction(getModel(), Key.LEFT));
                am.put("right-pressed", new KeyPressedAction(getModel(), Key.RIGHT));
                am.put("up-released", new KeyReleasedAction(getModel(), Key.UP));
                am.put("down-released", new KeyReleasedAction(getModel(), Key.DOWN));
                am.put("left-released", new KeyReleasedAction(getModel(), Key.LEFT));
                am.put("right-released", new KeyReleasedAction(getModel(), Key.RIGHT));
                am.put("fire", new FireBallAction(getModel()));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (Asset asset : getModel().getAssets()) {
                        asset.update(GamePane.this);
                    }
                    repaint();
                }
            });
            timer.start();
        }

        public GameModel getModel() {
            return model;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            for (Asset asset : getModel().getAssets()) {
                asset.paint(this, g2d);
            }
            g2d.dispose();
        }

    }

    public enum Key {

        LEFT,
        RIGHT,
        UP,
        DOWN
    }

    public interface GameModel {

        public void keyPressed(Key key);

        public void keyReleased(Key key);

        public boolean isKeyPressed(Key key);

        public void addFireball();

        public void remove(Asset asset);

        public Wizard getWizard();

        public Iterable<Asset> getAssets();

    }

    public class DefaultModel implements GameModel {

        private Set<Key> keys;
        private Wizard wizard;

        private List<Asset> assets;

        public DefaultModel() throws IOException {
            keys = new HashSet<>(25);
            assets = new ArrayList<>(25);
            wizard = new Wizard();
        }

        @Override
        public void keyPressed(Key key) {
            keys.add(key);
        }

        @Override
        public void keyReleased(Key key) {
            keys.remove(key);
        }

        @Override
        public boolean isKeyPressed(Key key) {
            return keys.contains(key);
        }

        @Override
        public Wizard getWizard() {
            return wizard;
        }

        @Override
        public void addFireball() {
            try {
                assets.add(new Fireball(getWizard()));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public void remove(Asset asset) {
            assets.remove(asset);
        }

        @Override
        public Iterable<Asset> getAssets() {
            List<Asset> proxy = new ArrayList<>(assets);
            proxy.add(wizard);
            return proxy;
        }

    }

    public abstract class AbstractGameAction extends AbstractAction {

        private GameModel model;

        public AbstractGameAction(GameModel model) {
            this.model = model;
        }

        public GameModel getModel() {
            return model;
        }

    }

    public abstract class AbstractKeyAction extends AbstractGameAction {

        private Key key;

        public AbstractKeyAction(GameModel model, Key key) {
            super(model);
            this.key = key;
        }

        public Key getKey() {
            return key;
        }

    }

    public class KeyPressedAction extends AbstractKeyAction {

        public KeyPressedAction(GameModel model, Key key) {
            super(model, key);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            getModel().keyPressed(getKey());
        }

    }

    public class KeyReleasedAction extends AbstractKeyAction {

        public KeyReleasedAction(GameModel model, Key key) {
            super(model, key);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            getModel().keyReleased(getKey());
        }

    }

    public class FireBallAction extends AbstractGameAction {

        public FireBallAction(GameModel model) {
            super(model);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            getModel().addFireball();
        }

    }

    public interface Asset {

        public void paint(GamePane surface, Graphics2D g2d);

        public void update(GamePane surface);

        public Rectangle getBounds();

    }

    public class Fireball implements Asset {

        private final BufferedImage fireball;
        private final Rectangle bounds;

        public Fireball(Wizard wizard) throws IOException {
            fireball = ImageIO.read(getClass().getResource("/Fireball.png"));
            bounds = new Rectangle();
            bounds.x = wizard.getBounds().x + wizard.getBounds().width;
            bounds.y = wizard.getBounds().y + (wizard.getBounds().height - fireball.getHeight());
            bounds.setSize(fireball.getWidth(), fireball.getHeight());
        }

        @Override
        public Rectangle getBounds() {
            return bounds;
        }

        @Override
        public void paint(GamePane surface, Graphics2D g2d) {

            Rectangle bounds = getBounds();
            g2d.drawImage(fireball, bounds.x, bounds.y, surface);

        }

        @Override
        public void update(GamePane surface) {
            Rectangle bounds = getBounds();
            bounds.x += 8;
            if (bounds.x > surface.getWidth()) {
                surface.getModel().remove(this);
            }
        }

    }

    public class Wizard implements Asset {

        private final BufferedImage wizard;
        private final Rectangle bounds;
        private boolean initialised = false;

        public Wizard() throws IOException {
            wizard = ImageIO.read(getClass().getResource("/Wizard.png"));
            bounds = new Rectangle(wizard.getWidth(), wizard.getHeight());
        }

        @Override
        public Rectangle getBounds() {
            return bounds;
        }

        @Override
        public void paint(GamePane surface, Graphics2D g2d) {

            Rectangle bounds = getBounds();
            Point point = bounds.getLocation();
            if (!initialised) {
                point = new Point(5, (surface.getHeight() - bounds.height) / 2);
                bounds.setLocation(point);
                initialised = true;
            }

            g2d.drawImage(wizard, point.x, point.y, surface);

        }

        @Override
        public void update(GamePane surface) {
            Rectangle bounds = getBounds();
            Point point = bounds.getLocation();
            if (initialised) {
                GameModel model = surface.getModel();
                if (model.isKeyPressed(Key.UP)) {
                    point.y -= 4;
                } else if (model.isKeyPressed(Key.DOWN)) {
                    point.y += 4;
                }

                if (point.y < 0) {
                    point.y = 0;
                } else if (point.y + bounds.height > surface.getHeight()) {
                    point.y = surface.getHeight() - bounds.height;
                }
                bounds.setLocation(point);
            }
        }
    }

}