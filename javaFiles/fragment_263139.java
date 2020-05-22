import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager2;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.EventObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.event.EventListenerList;

public class TestAnimatedLayout {

    public static void main(String[] args) {
        new TestAnimatedLayout();
    }

    public TestAnimatedLayout() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestAnimatedLayoutPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public class TestAnimatedLayoutPane extends JPanel {

        private Card card1, card2;

        public TestAnimatedLayoutPane() {
            AnimatedLayout animatedLayout = new AnimatedLayout(new GridBagLayout());
            animatedLayout.addLayoutAnimationListener(new LayoutAnimationListener() {
                @Override
                public void layoutAnimationStopped(LayoutAnimationEvent evt) {
                    System.out.println("Stoppped");
                    if (card2 == null) {
                        card2 = new Card("2");
                        GridBagConstraints gbc = new GridBagConstraints();
                        gbc.insets = new Insets(4, 4, 4, 4);
                        gbc.gridx = 1;
                        gbc.gridy = 0;
                        add(card2, gbc);
                        revalidate();
                    }
                }
            });
            setLayout(animatedLayout);
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(4, 4, 4, 4);
            gbc.gridx = 0;
            gbc.gridy = 0;
            card1 = new Card("1");
            add(card1, gbc);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

    public class Card extends JLabel {

        public Card(String text) {
            super(text);
            setHorizontalAlignment(CENTER);
            setVerticalAlignment(CENTER);
            setBorder(new LineBorder(Color.BLACK));
            setOpaque(true);
            setBackground(Color.WHITE);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(50, 100);
        }

    }

    public class LayoutAnimationEvent extends EventObject {

        private Container parent;

        public LayoutAnimationEvent(AnimatedLayout source, Container parent) {
            super(source);
            this.parent = parent;
        }

        public Container getParent() {
            return parent;
        }

        public AnimatedLayout getAnimationLayout() {
            return (AnimatedLayout) getSource();
        }

    }

    public interface LayoutAnimationListener extends EventListener {

        public void layoutAnimationStopped(LayoutAnimationEvent evt);

    }

    public class AnimatedLayout implements LayoutManager2 {

        private EventListenerList listenerList = new EventListenerList();

        private LayoutManager2 proxy;
        private Map<Component, Rectangle> mapStart;
        private Map<Component, Rectangle> mapTarget;
        private Map<Container, Timer> mapTrips;
        private Map<Container, Animator> mapAnimators;

        public AnimatedLayout(LayoutManager2 proxy) {
            this.proxy = proxy;
            mapTrips = new WeakHashMap<>(5);
            mapAnimators = new WeakHashMap<>(5);
        }

        public void addLayoutAnimationListener(LayoutAnimationListener listener) {
            listenerList.add(LayoutAnimationListener.class, listener);
        }

        public void removeLayoutAnimationListener(LayoutAnimationListener listener) {
            listenerList.add(LayoutAnimationListener.class, listener);
        }

        protected void fireAnimationStopped(Container parent) {
            LayoutAnimationListener[] listeners = listenerList.getListeners(LayoutAnimationListener.class);
            if (listeners != null && listeners.length > 0) {
                LayoutAnimationEvent evt = new LayoutAnimationEvent(this, parent);
                for (LayoutAnimationListener listener : listeners) {
                    listener.layoutAnimationStopped(evt);
                }
            }
        }

        @Override
        public void addLayoutComponent(String name, Component comp) {
            proxy.addLayoutComponent(name, comp);
        }

        @Override
        public void removeLayoutComponent(Component comp) {
            proxy.removeLayoutComponent(comp);
        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            return proxy.preferredLayoutSize(parent);
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            return proxy.minimumLayoutSize(parent);
        }

        @Override
        public void layoutContainer(Container parent) {
            Timer timer = mapTrips.get(parent);
            if (timer == null) {
                System.out.println("...create new trip");
                timer = new Timer(125, new TripAction(parent));
                timer.setRepeats(false);
                timer.setCoalesce(false);
                mapTrips.put(parent, timer);
            }
            System.out.println("trip...");
            timer.restart();
        }

        protected void doLayout(Container parent) {

            System.out.println("doLayout...");

            mapStart = new HashMap<>(parent.getComponentCount());

            for (Component comp : parent.getComponents()) {
                mapStart.put(comp, (Rectangle) comp.getBounds().clone());
            }

            proxy.layoutContainer(parent);

            LayoutConstraints constraints = new LayoutConstraints();
            for (Component comp : parent.getComponents()) {
                Rectangle bounds = comp.getBounds();
                Rectangle startBounds = mapStart.get(comp);
                if (!mapStart.get(comp).equals(bounds)) {

                    if (startBounds.x == 0 && startBounds.y == 0) {

                        startBounds.x = (parent.getWidth() - startBounds.width) / 2;
                        startBounds.y = (parent.getHeight() - startBounds.height) / 2;

                    }

                    comp.setBounds(startBounds);
                    constraints.add(comp, startBounds, bounds);
                }
            }

            System.out.println("Items to layout " + constraints.size());
            if (constraints.size() > 0) {
                Animator animator = mapAnimators.get(parent);
                if (animator == null) {
                    animator = new Animator(this, parent, constraints);
                    mapAnimators.put(parent, animator);
                } else {
                    animator.setConstraints(constraints);
                }
                animator.restart();
            } else {
                if (mapAnimators.containsKey(parent)) {
                    Animator animator = mapAnimators.get(parent);
                    animator.stop();
                    mapAnimators.remove(parent);
                }
            }

        }

        @Override
        public void addLayoutComponent(Component comp, Object constraints) {
            proxy.addLayoutComponent(comp, constraints);
        }

        @Override
        public Dimension maximumLayoutSize(Container target) {
            return proxy.maximumLayoutSize(target);
        }

        @Override
        public float getLayoutAlignmentX(Container target) {
            return proxy.getLayoutAlignmentX(target);
        }

        @Override
        public float getLayoutAlignmentY(Container target) {
            return proxy.getLayoutAlignmentY(target);
        }

        @Override
        public void invalidateLayout(Container target) {
            proxy.invalidateLayout(target);
        }

        protected void animationDidStop(Container parent) {
            fireAnimationStopped(parent);
        }

        protected class TripAction implements ActionListener {

            private Container container;

            public TripAction(Container container) {
                this.container = container;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("...trip");
                mapTrips.remove(container);
                doLayout(container);
            }

        }

    }

    public class LayoutConstraints {

        private List<AnimationBounds> animationBounds;

        public LayoutConstraints() {
            animationBounds = new ArrayList<AnimationBounds>(25);
        }

        public void add(Component comp, Rectangle startBounds, Rectangle targetBounds) {

            add(new AnimationBounds(comp, startBounds, targetBounds));

        }

        public void add(AnimationBounds bounds) {

            animationBounds.add(bounds);

        }

        public int size() {
            return animationBounds.size();
        }

        public AnimationBounds[] getAnimationBounds() {

            return animationBounds.toArray(new AnimationBounds[animationBounds.size()]);

        }

    }

    public class AnimationBounds {

        private Component component;
        private Rectangle startBounds;
        private Rectangle targetBounds;

        public AnimationBounds(Component component, Rectangle startBounds, Rectangle targetBounds) {
            this.component = component;
            this.startBounds = startBounds;
            this.targetBounds = targetBounds;
        }

        public Rectangle getStartBounds() {
            return startBounds;
        }

        public Rectangle getTargetBounds() {
            return targetBounds;
        }

        public Component getComponent() {
            return component;
        }

        public Rectangle getBounds(float progress) {

            return calculateProgress(getStartBounds(), getTargetBounds(), progress);

        }

    }

    public static Rectangle calculateProgress(Rectangle startBounds, Rectangle targetBounds, float progress) {

        Rectangle bounds = new Rectangle();

        if (startBounds != null && targetBounds != null) {

            bounds.setLocation(calculateProgress(startBounds.getLocation(), targetBounds.getLocation(), progress));
            bounds.setSize(calculateProgress(startBounds.getSize(), targetBounds.getSize(), progress));

        }

        return bounds;

    }

    public static Point calculateProgress(Point startPoint, Point targetPoint, float progress) {

        Point point = new Point();

        if (startPoint != null && targetPoint != null) {

            point.x = calculateProgress(startPoint.x, targetPoint.x, progress);
            point.y = calculateProgress(startPoint.y, targetPoint.y, progress);

        }

        return point;

    }

    public static Dimension calculateProgress(Dimension startSize, Dimension targetSize, float progress) {

        Dimension size = new Dimension();

        if (startSize != null && targetSize != null) {

            size.width = calculateProgress(startSize.width, targetSize.width, progress);
            size.height = calculateProgress(startSize.height, targetSize.height, progress);

        }

        return size;

    }

    public static int calculateProgress(int startValue, int endValue, float fraction) {

        int value = 0;
        int distance = endValue - startValue;
        value = (int) ((float) distance * fraction);
        value += startValue;

        return value;

    }

    public class Animator implements ActionListener {

        private Timer timer;
        private LayoutConstraints constraints;
        private int tick;
        private Container parent;
        private AnimatedLayout layout;

        public Animator(AnimatedLayout layout, Container parent, LayoutConstraints constraints) {
            setConstraints(constraints);
            timer = new Timer(16, this);
            timer.setRepeats(true);
            timer.setCoalesce(true);
            this.parent = parent;
            this.layout = layout;
        }

        private void setConstraints(LayoutConstraints constraints) {
            this.constraints = constraints;
        }

        public void restart() {
            tick = 0;
            timer.restart();
        }

        protected void stop() {
            timer.stop();
            tick = 0;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            tick += 16;
            float progress = (float) tick / (float) 1000;
            if (progress >= 1f) {
                progress = 1f;
                timer.stop();
                layout.animationDidStop(parent);
            }

            for (AnimationBounds ab : constraints.getAnimationBounds()) {
                Rectangle bounds = ab.getBounds(progress);
                Component comp = ab.getComponent();
                comp.setBounds(bounds);
                comp.invalidate();
                comp.repaint();
            }

            parent.repaint();

        }

    }

}