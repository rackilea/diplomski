import java.awt.AlphaComposite;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FadingLabels {

    public static void main(String[] args) {
        new FadingLabels();
    }

    public FadingLabels() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                final List<FadingLabel> labels = new ArrayList<>(25);
                labels.add(new FadingLabel("A "));
                labels.add(new FadingLabel("long "));
                labels.add(new FadingLabel("time "));
                labels.add(new FadingLabel("ago "));
                labels.add(new FadingLabel("in "));
                labels.add(new FadingLabel("a "));
                labels.add(new FadingLabel("galaxy "));
                labels.add(new FadingLabel("far, "));
                labels.add(new FadingLabel("far, "));
                labels.add(new FadingLabel("away"));
                labels.add(new FadingLabel("..."));

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridBagLayout());

                for (FadingLabel label : labels) {
                    frame.add(label);
                }

                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (FadingLabel label : labels) {
                            label.fadeIn();
                            label.waitFor();
                        }
                    }
                }).start();

            }
        });
    }

    public class FadingLabel extends JLabel {

        protected static final int TIME = 1000;
        protected final Object fadeLock = new Object();

        private float targetAlpha;
        private float alpha = 0;
        private Timer timer;
        private long startTime;
        private float fromAlpha;

        public FadingLabel() {
            init();
        }

        public FadingLabel(String text, Icon icon, int horizontalAlignment) {
            super(text, icon, horizontalAlignment);
            init();
        }

        public FadingLabel(String text, int horizontalAlignment) {
            super(text, horizontalAlignment);
            init();
        }

        public FadingLabel(String text) {
            super(text);
            init();
        }

        public FadingLabel(Icon image, int horizontalAlignment) {
            super(image, horizontalAlignment);
            init();
        }

        public FadingLabel(Icon image) {
            super(image);
            init();
        }

        protected void init() {

            timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (alpha < 1f) {
                        long now = System.currentTimeMillis();
                        long diff = now - startTime;
                        float progress = (float) diff / (float) TIME;

                        float distance = targetAlpha - fromAlpha;
                        alpha = (float) (distance * progress);
                        alpha += fromAlpha;

                        if (alpha > 1f) {
                            timer.stop();
                            alpha = 1f;
                        }

                    } else {
                        alpha = 1f;
                        timer.stop();
                    }
                    repaint();
                    if (!timer.isRunning()) {
                        synchronized (fadeLock) {
                            fadeLock.notifyAll();
                        }
                    }
                }
            });
            timer.setInitialDelay(0);

        }

        protected void fadeTo(float target) {
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    timer.stop();
                    fromAlpha = alpha;
                    targetAlpha = target;
                    if (targetAlpha != alpha) {
                        startTime = System.currentTimeMillis();
                        timer.start();
                    } else {
                        repaint();
                    }
                }
            };
            if (EventQueue.isDispatchThread()) {
                run.run();
            } else {
                EventQueue.invokeLater(run);
            }
        }

        public void fadeIn() {
            fadeTo(1f);
        }

        public void fadeOut() {
            fadeTo(0f);
        }

        public void waitFor() {
            if (EventQueue.isDispatchThread()) {
                throw new IllegalStateException("Calling waitFor while within the EDT!");
            }
            synchronized (fadeLock) {
                try {
                    fadeLock.wait();
                } catch (InterruptedException ex) {
                }
            }
        }

        @Override
        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setComposite(AlphaComposite.SrcOver.derive(alpha));
            super.paint(g2d);
            g2d.dispose();
        }

    }

}