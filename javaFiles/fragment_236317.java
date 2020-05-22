import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class StickyGlassPaneExample {

    public static void main(String[] args) {
        new StickyGlassPaneExample();
    }

    public StickyGlassPaneExample() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                StickyGlassPane stickyGlassPane = new StickyGlassPane();
                TestPane testPane = new TestPane(stickyGlassPane);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(testPane);
                frame.setSize(600, 500);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.setGlassPane(stickyGlassPane);
                stickyGlassPane.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private List<JTextField> fields;

        public TestPane(StickyGlassPane stickyGlassPane) {
            fields = new ArrayList<JTextField>(100);
            for (int index = 0; index < 100; index++) {
                JTextField field = new JTextField(10);
                fields.add(field);
                add(field);
            }
            int fieldIndex = (int)(Math.random() * (fields.size() - 1));
            JTextField sticky = fields.get(fieldIndex);
            sticky.setText("Sticky");
            stickyGlassPane.setStickyComponent(sticky);
        }
    }

    public class StickyGlassPane extends JPanel {

        private Component component;

        private JPanel overlay;

        public StickyGlassPane() {
            setOpaque(false);
            overlay = new JPanel() {

                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2d = (Graphics2D) g.create();
                    g2d.setColor(Color.RED);
                    g2d.drawRect(0, 0, getWidth(), getHeight());
                    g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                }

            };
            overlay.setOpaque(false);

            add(overlay);
        }

        @Override
        public void doLayout() {
            if (component != null) {
                Point p = component.getLocation();
                SwingUtilities.convertPoint(component, p, this);
                overlay.setLocation(p);
                overlay.setSize(component.getSize());
            } else {
                overlay.setBounds(0, 0, 0, 0);
            }
        }

        public void setStickyComponent(Component component) {
            this.component = component;
            revalidate();
        }

    }

}