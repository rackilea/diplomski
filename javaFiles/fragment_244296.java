import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EventListener;
import java.util.EventObject;
import javaapplication222.Test.TestPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
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

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new BorderLayout());
            ClosingTabbedPane ctp = new ClosingTabbedPane();

            ctp.addTab("Bananas", createPanel("Hello"));
            ctp.addTab("Apples", createPanel("Kanchiwa"));
            add(ctp);
        }

        protected JPanel createPanel(String msg) {

            JPanel panel = new JPanel(new GridBagLayout());
            JLabel label = new JLabel(msg);
            MouseAdapter ma = new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("clicked");
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    System.out.println("in");
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    System.out.println("out");
                }

            };
            label.addMouseListener(ma);
            label.addMouseMotionListener(ma);
            panel.add(label);

            return panel;

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

    public class ClosingTabbedPane extends JTabbedPane {

        /**
         *
         */
        private static final long serialVersionUID = 1L;

        public ClosingTabbedPane() {
        }

        @Override
        public void addTab(String title, Component component) {
            super.addTab(title, component);
            final int index = getTabCount() - 1;
            TabComponent tabLabel = new TabComponent(title);
            tabLabel.addTabEventListener(new TabEventListener() {
                @Override
                public void handleEvent(TabEvent evt) {
                    System.out.println("Boo");
//                  if (evt.getEventType() == TabEvent.TAB_CLOSING) {
//                      ClosingTabbedPane.this.removeTabAt(index);
//                  }
                }
            });
            setTabComponentAt(index, tabLabel);
        }
    }

    public class TabEvent extends EventObject {

        public TabEvent(Object source) {
            super(source);
        }

    }

    public interface TabEventListener extends EventListener {

        public void handleEvent(TabEvent evt);

    }

    public static class CloseIcon extends JPanel {

        private static final Dimension CROSS_ICON_SIZE = new Dimension(15, 15);
        private static final int CROSS_ICON_INSET = 5;
        private boolean mouseInTheHouse = false;

        public CloseIcon() {
            setOpaque(false);

            addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    fireActionPerformed();
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    mouseInTheHouse = true;
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    mouseInTheHouse = false;
                }

            });
        }

        public void addActionListener(ActionListener listener) {
            listenerList.add(ActionListener.class, listener);
        }

        protected void fireActionPerformed() {
            ActionListener[] listeners = listenerList.getListeners(ActionListener.class);
            if (listeners.length > 0) {
                ActionEvent evt = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Closed");
                for (ActionListener listener : listeners) {
                    listener.actionPerformed(evt);
                }
            }
        }

        //You don't have to override the getSize() versions. It basically calls getWidth() and getHeight()
        //Also you should NOT override getWidth() and getHeight() because the layout managers set that properties
        //If you do the borders right/bottom edges won't be painted correctly
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(CROSS_ICON_SIZE.width + CROSS_ICON_INSET, CROSS_ICON_SIZE.height);
        }

        @Override
        public Dimension getMinimumSize() {
            return getPreferredSize();
        }

        @Override
        public Dimension getMaximumSize() {
            return getPreferredSize();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D gfx = (Graphics2D) g.create();

            int componentWidth = getWidth();
            int ovalRadius = (int) (CROSS_ICON_SIZE.getWidth());
            Insets insets = getInsets();
            Point gfxXlatePoint = new Point(componentWidth - (int) CROSS_ICON_SIZE.getWidth() - insets.right, insets.top);
            Rectangle paintRectangle = new Rectangle(gfxXlatePoint, CROSS_ICON_SIZE);
            gfx.translate(gfxXlatePoint.x, gfxXlatePoint.y);

            gfx.setStroke(new BasicStroke(2));
            gfx.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Insets crossIconPadding = new Insets(5, 5, 5, 5);
            if (mouseInTheHouse) {
                gfx.setColor(new Color(0xf49f94));
                //The mouse pointer is on the x mark
                gfx.fillOval(0, 0, ovalRadius, ovalRadius);
                gfx.setColor(Color.WHITE);
                gfx.drawLine(0 + crossIconPadding.left, 0 + crossIconPadding.top, (int) CROSS_ICON_SIZE.getWidth() - crossIconPadding.right, (int) CROSS_ICON_SIZE.getHeight() - crossIconPadding.bottom);
                gfx.drawLine((int) CROSS_ICON_SIZE.getWidth() - crossIconPadding.right, 0 + crossIconPadding.top, 0 + crossIconPadding.left, (int) CROSS_ICON_SIZE.getHeight() - crossIconPadding.bottom);
            } else {
                gfx.setColor(Color.BLACK);
                gfx.drawLine(0 + crossIconPadding.left, 0 + crossIconPadding.top, (int) CROSS_ICON_SIZE.getWidth() - crossIconPadding.right, (int) CROSS_ICON_SIZE.getHeight() - crossIconPadding.bottom);
                gfx.drawLine((int) CROSS_ICON_SIZE.getWidth() - crossIconPadding.right, 0 + crossIconPadding.top, 0 + crossIconPadding.left, (int) CROSS_ICON_SIZE.getHeight() - crossIconPadding.bottom);
            }
            gfx.dispose();
        }

    }

    public class TabComponent extends JPanel {

        private CloseIcon closeIcon;

        public TabComponent(String title) {
            setLayout(new GridBagLayout());
            setOpaque(false);

            JLabel lblTitle = new JLabel(title);
            closeIcon = new CloseIcon();
            closeIcon.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fireTabEvent(new TabEvent(this));//, TabEvent.TAB_CLOSING));
                }
            });

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.anchor = GridBagConstraints.WEST;
            add(lblTitle, gbc);

            gbc.gridx++;
            gbc.weightx = 0;
            gbc.anchor = GridBagConstraints.NORTHEAST;
            add(closeIcon);

        }

        public void addTabEventListener(TabEventListener listener) {
            listenerList.add(TabEventListener.class, listener);
        }

        public void removeTabEventListener(TabEventListener listener) {
            listenerList.remove(TabEventListener.class, listener);
        }

        protected void fireTabEvent(TabEvent evt) {
            Object[] listeners = listenerList.getListeners(TabEventListener.class);
            for (int i = 0, n = listeners.length; i < n; i++) {
                ((TabEventListener) listeners[i]).handleEvent(evt);
            }
        }

    }
}