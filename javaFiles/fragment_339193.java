import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class GridBagLayoutTest {

    public static void main(String[] args) {
        new GridBagLayoutTest();
    }

    public GridBagLayoutTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                final TestPane pane = new TestPane();
                JButton btn = new JButton("Add");
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        pane.addNewItem();
                    }
                });

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(pane);
                frame.add(btn, BorderLayout.SOUTH);
                frame.pack();
                frame.setSize(300, 300);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private int gridX = 0;
        private int gridY = 0;
        private JLabel filler;

        private int columnCount = 4;

        public TestPane() {
            setLayout(new GridBagLayout());
            filler = new JLabel();
        }

        public void addNewItem() {

            remove(filler);

            JLabel label = new JLabel("Cell " + gridX + "x" + gridY);
            label.setBorder(new EmptyBorder(10, 10, 10, 10));
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = gridX;
            gbc.gridy = gridY;
            add(label, gbc);
            gridX++;
            if (gridX >= columnCount) {
                gridX = 0;
                gridY++;
            }

            gbc = new GridBagConstraints();
            gbc.gridx = columnCount;
            gbc.gridy = gridY + 1;
            gbc.weightx = 1;
            gbc.weighty = 1;
            add(filler, gbc);

            revalidate();
            repaint();

        }

    }

}