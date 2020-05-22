import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ListPanel extends JFrame {

    private static final long serialVersionUID = 1L;
    private DefaultListModel model = new DefaultListModel();
    private int i = 01;

    public ListPanel() {
        model.addElement(createPanel("one" + i++));
        model.addElement(createPanel("two" + i++));
        model.addElement(createPanel("three" + i++));
        model.addElement(createPanel("four" + i++));
        JList list = new JList(model);
        list.setCellRenderer(new PanelRenderer());
        add(new JScrollPane(list));
        JButton btn = new JButton("Remove All Rows :");
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                model.removeAllElements();
            }
        });
        add(btn, BorderLayout.SOUTH);
        JButton btn1 = new JButton("Add New Rows:");
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                model.addElement(createPanel("one" + i++));
                model.addElement(createPanel("two" + i++));
                model.addElement(createPanel("three" + i++));
                model.addElement(createPanel("four" + i++));
            }
        });
        add(btn1, BorderLayout.NORTH);
    }

    public static JPanel createPanel(String text) {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Item: "));
        panel.add(new JLabel(text));
        return panel;
    }

    public static void main(String[] args) {
        UIManager.getLookAndFeelDefaults().put("List.selectionBackground", Color.red);
        ListPanel frame = new ListPanel();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private class PanelRenderer implements ListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JPanel renderer = (JPanel) value;
            renderer.setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
            return renderer;
        }
    }
}