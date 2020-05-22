import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @see https://stackoverflow.com/a/25170471/230513
 */
public class ListDisplayPanel {

    private static final Icon icon = UIManager.getIcon("html.pendingImage");

    private ListPanel listPanel = new ListPanel();
    private DisplayPanel displayPanel = new DisplayPanel();

    private class DisplayPanel extends JPanel {

        private static final int SIZE = 256;
        private JLabel label = new JLabel();

        public DisplayPanel() {
            this.add(label);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            BufferedImage img = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D temp = (Graphics2D) img.getGraphics();
            icon.paintIcon(this, temp, 0, 0);
            temp.dispose();
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(SIZE, SIZE);
        }
    }

    private class ListPanel extends JPanel {

        private static final int N = 5;
        private DefaultListModel dlm = new DefaultListModel();
        private JList list = new JList(dlm);

        public ListPanel() {
            super(new GridLayout());
            for (int i = 0; i < N * N; i++) {
                String name = "Cell-" + String.format("%02d", i);
                dlm.addElement(name);
            }
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
            list.setVisibleRowCount(N);
            list.setCellRenderer(new ListRenderer());
            list.addListSelectionListener(new SelectionHandler());
            this.add(list);
        }

        private class ListRenderer extends DefaultListCellRenderer {

            @Override
            public Component getListCellRendererComponent(JList list,
                    Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(
                        list, value, index, isSelected, cellHasFocus);
                label.setBorder(BorderFactory.createEmptyBorder(N, N, N, N));
                label.setIcon(icon);
                label.setHorizontalTextPosition(JLabel.CENTER);
                label.setVerticalTextPosition(JLabel.BOTTOM);
                return label;
            }
        }

        private class SelectionHandler implements ListSelectionListener {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    displayPanel.label.setText((String) dlm.getElementAt(e.getLastIndex()));
                }
            }
        }
    }

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JSplitPane jsp = new JSplitPane();
        jsp.setRightComponent(new JScrollPane(listPanel));
        jsp.setLeftComponent(displayPanel);
        f.add(jsp);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new ListDisplayPanel().display();
        });
    }
}