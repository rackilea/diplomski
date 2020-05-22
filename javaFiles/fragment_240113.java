import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.plaf.LayerUI;

/**
 */
public class MediaPlayer {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Media Clone");
                MediaController mediaController = new MediaController();
                frame.getContentPane().add(new MediaView(mediaController));
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setMinimumSize(new Dimension(800, 450));
                frame.setLocationRelativeTo(null); // Center
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    static class MediaView extends JPanel {

        private MediaList mediaList;
        private ButtonView buttonView;
        private MediaController controller;

        MediaView(MediaController controller) {
            this.controller = controller;
            createComponents();
            makeLayout();
        }

        public void createComponents() {
            mediaList = new MediaList();
            buttonView = new ButtonView(controller);
        }

        public void makeLayout() {
            setLayout(new BorderLayout());
            add(mediaList);
            add(new JLayer<>(buttonView, new GradientUI()), BorderLayout.NORTH);
        }
    }

    static class MediaList extends JPanel {

        private JTable mediaTable;

        MediaList() {
            createComponents();
            makeLayout();
        }

        public void createComponents() {
            String[] header = new String[]{"Song", "Artist"};
            String[][] model = new String[2][2];
            model[0][0] = "Hello";
            model[0][1] = "World";
            model[1][0] = "Goodbye";
            model[1][1] = "Sunshine";
            mediaTable = new JTable(model, header);
        }

        public void makeLayout() {
            setLayout(new BorderLayout());
            add(new JScrollPane(mediaTable));
        }
    }

    static class GradientUI extends LayerUI<JComponent> {

        @Override
        public void paint(Graphics g, JComponent c) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            int height = c.getHeight();
            int width = c.getWidth();
            g2.setPaint(new GradientPaint(0, 0, new Color(136, 146, 155), 0, height, new Color(101, 108, 116)));
            Rectangle2D area = new Rectangle(0, 0, width, height);
            g2.fill(area);
            super.paint(g2, c);
        }
    }

    enum MediaAction {
        PLAY, NEXT, PREVIOUS
    }

    static class MediaController {

        private Toolkit toolkit = Toolkit.getDefaultToolkit();

        public void execute(MediaAction mediaAction) {
            toolkit.beep();
            System.out.println(mediaAction.name());
        }
    }

    static class ButtonView extends JPanel {

        private static Logger log = Logger.getLogger(ButtonView.class.getName());

        private JButton play;
        private JButton next;
        private JButton previous;
        private RoundButtonUI playUI;
        private ActionListener playActionListener;
        private ActionListener nextActionListener;
        private ActionListener previousActionListener;
        private MediaController controller;

        ButtonView(MediaController controller) {
            this.controller = controller;
            createComponents();
            makeLayout();
            createHandlers();
            registerHandlers();
            initComponent();
        }

        public void createComponents() {
            play = new JButton();
            next = new JButton();
            previous = new JButton();
            playUI = new RoundButtonUI();
        }

        public void createHandlers() {
            playActionListener = createMediaAction(MediaAction.PLAY);
            nextActionListener = createMediaAction(MediaAction.NEXT);
            previousActionListener = createMediaAction(MediaAction.PREVIOUS);
        }

        private ActionListener createMediaAction(final MediaAction mediaAction) {
            return new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            controller.execute(mediaAction);
                        }
                    });
                }
            };
        }

        public void registerHandlers() {
            play.addActionListener(playActionListener);
            next.addActionListener(nextActionListener);
            previous.addActionListener(previousActionListener);
        }

        public void makeLayout() {
            setLayout(new FlowLayout(FlowLayout.LEADING));
            makeButtonRound(previous, "<<", "bullet_triangle_grey_shadow.png", "bullet_triangle_grey.png");
            makeButtonRound(play, ">", "bullet_triangle_glass_grey128x128.png", "bullet_triangle_glass_grey128x128.png");
            makeButtonRound(next, ">>", "bullet_triangle_grey_shadow.png", "bullet_triangle_grey.png");
            add(new JLayer<>(previous, playUI));
            add(new JLayer<>(play, playUI));
            add(new JLayer<>(next, playUI));
        }

        public void initComponent() {
            setOpaque(false);
        }

        private void makeButtonRound(final JButton toBeRounded, String fallback, String imageNormal, String imagePressed) {
            toBeRounded.setOpaque(false);
            toBeRounded.setFocusPainted(false);
            toBeRounded.setBorderPainted(false);
            toBeRounded.setContentAreaFilled(false);
            toBeRounded.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5));
            URL normalURL = getClass().getClassLoader().getResource(imageNormal);
            URL pressedURL = getClass().getClassLoader().getResource(imagePressed);
            if (normalURL != null || pressedURL != null) {
                final ImageIcon released = new ImageIcon(normalURL);
                final ImageIcon pressed = new ImageIcon(pressedURL);
                toBeRounded.setIcon(released);
                toBeRounded.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        toBeRounded.setIcon(pressed);
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        toBeRounded.setIcon(released);
                    }
                });
            } else {
                toBeRounded.setText(fallback);
                log.severe("Missing resources: " + imageNormal + " and " + imagePressed);
            }
        }
    }

    /**
     * Shifts the image so it looks pressed down.
     * Creates a circle around the icon, that varies in size depending on the supplied icon.
     */
    static class RoundButtonUI extends LayerUI<JComponent> {

        private static final int STROKE_WIDTH = 5;

        @Override
        public void paint(Graphics g, JComponent c) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            ButtonModel buttonModel;
            JButton b;

            if (((JLayer) c).getView() instanceof JButton) {
                b = (JButton) ((JLayer) c).getView();
                buttonModel = b.getModel();
            } else {
                super.paint(g, c);
                return;
            }

            int iconHeight = b.getIcon() != null ? b.getIcon().getIconHeight() : 60;
            int iconWidth = b.getIcon() != null ? b.getIcon().getIconWidth() : 60;

            Shape circle = new Ellipse2D.Double(STROKE_WIDTH, STROKE_WIDTH, iconHeight, iconWidth);

            g2.setPaint(new GradientPaint(5, 5, new Color(222, 224, 230), 30, 55, new Color(187, 189, 199)));
            g2.fill(circle);

            g2.setPaint(new GradientPaint(15, 0, new Color(90, 97, 105), 15, 30, new Color(132, 142, 152)));
            g2.setStroke(new BasicStroke(5));
            g2.draw(circle);

            if (buttonModel.isPressed()) {
                g2.translate(1, 1);
            }

            super.paint(g2, c);
            g2.dispose();
        }
    }
}