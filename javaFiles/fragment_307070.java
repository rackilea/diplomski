import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class TestJList {

    class CD {
        public CD(String n) {
            name = n;
        }

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String n) {
            name = n;
        }
    }

    protected void initUI() {
        List<CD> cds = new ArrayList<CD>();
        cds.add(new CD("MJ - Bad"));
        cds.add(new CD("Mozart - Concerto 123"));
        cds.add(new CD("Nadeah - Odile"));
        JFrame frame = new JFrame(TestJList.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JList list = new JList(new Vector<CD>(cds));
        list.setVisibleRowCount(10);
        list.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (renderer instanceof JLabel && value instanceof CD) {
                    // Here value will be of the Type 'CD'
                    ((JLabel) renderer).setText(((CD) value).getName());
                }
                return renderer;
            }
        });
        frame.add(new JScrollPane(list));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestJList().initUI();
            }
        });
    }
}