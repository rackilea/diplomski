import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.Scrollable;
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

                TestPane tp = new TestPane();
                JButton add = new JButton("Add Row");
                add.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        tp.addRow();
                    }
                });

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(tp));
                frame.add(add, BorderLayout.SOUTH);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel implements Scrollable {

        private JPanel content;
        private JPanel filler;

        private GridBagConstraints masterConstraints;

        public TestPane() {

            content = new JPanel(new GridBagLayout());
            filler = new JPanel();

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            add(content, gbc);
            gbc.weighty = 1;
            add(filler, gbc);

            masterConstraints = new GridBagConstraints();
            masterConstraints.gridwidth = GridBagConstraints.REMAINDER;
            masterConstraints.weightx = 1;
            masterConstraints.fill = GridBagConstraints.HORIZONTAL;
        }

        public void addRow() {
            JLabel label = new JLabel("This is just a label, but technically, you can anythig you want");
            content.add(label, masterConstraints);
            revalidate();
            repaint();
        }

        @Override
        public Dimension getPreferredScrollableViewportSize() {
            return new Dimension(200, 200);
        }

        @Override
        public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
            return 64;
        }

        @Override
        public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
            return 64;
        }

        @Override
        public boolean getScrollableTracksViewportWidth() {
            Container parent = getParent();
            boolean trackWidth = false;
            if (parent instanceof JViewport) {
                trackWidth = parent.getHeight() > getPreferredSize().width;
            }
            return trackWidth;
        }

        @Override
        public boolean getScrollableTracksViewportHeight() {
            Container parent = getParent();
            boolean trackHeight = false;
            if (parent instanceof JViewport) {
                trackHeight = parent.getHeight() > getPreferredSize().height;
            }
            return trackHeight;
        }

    }

}