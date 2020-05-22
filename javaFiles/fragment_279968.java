import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class BlockComboBoxExample extends JFrame {

    private static final long serialVersionUID = 1L;
    final String SEPARATOR = "SEPARATOR";

    public BlockComboBoxExample() {
        super("Block ComboBox Example");
        String[][] str = {{"A", "B", "C"}, {"1", "2", "3"}, {"abc", "def", "ghi"}};
        JComboBox combo = new JComboBox(makeVectorData(str));
        combo.setRenderer(new ComboBoxRenderer());
        combo.addActionListener(new BlockComboListener(combo));
        combo.setPrototypeDisplayValue("XXXXXXXXXXXXXXXXX");
        setLayout(new FlowLayout());
        add(combo);
        pack();
        setVisible(true);
    }

    private Vector<String> makeVectorData(String[][] str) {
        boolean needSeparator = false;
        Vector<String> data = new Vector<String>();
        for (int i = 0; i < str.length; i++) {
            if (needSeparator) {
                data.addElement(SEPARATOR);
            }
            for (int j = 0; j < str[i].length; j++) {
                data.addElement(str[i][j]);
                needSeparator = true;
            }
        }
        return data;
    }

    public static void main(String args[]) {
        try {
        for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(laf.getName())) {
                UIManager.setLookAndFeel(laf.getClassName());
                //UIManager.getLookAndFeelDefaults().put("Panel.background", Color.white);
                //UIManager.getLookAndFeelDefaults().put("Button.contentMargins", new InsetsUIResource(0,0,0,0));
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

        BlockComboBoxExample frame = new BlockComboBoxExample();
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private class ComboBoxRenderer extends JLabel implements ListCellRenderer {

        private static final long serialVersionUID = 1L;
        private JSeparator separator;

        public ComboBoxRenderer() {
            setOpaque(true);
            setBorder(new EmptyBorder(1, 1, 1, 1));
            separator = new JSeparator(JSeparator.HORIZONTAL);
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {
            String str = (value == null) ? "" : value.toString();
            if (SEPARATOR.equals(str)) {
                return separator;
            }
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
            setFont(list.getFont());
            setText(str);
            return this;
        }
    }

    private class BlockComboListener implements ActionListener {

        private JComboBox combo;
        private Object currentItem;

        BlockComboListener(JComboBox combo) {
            this.combo = combo;
            combo.setSelectedIndex(0);
            currentItem = combo.getSelectedItem();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String tempItem = (String) combo.getSelectedItem();
            if (SEPARATOR.equals(tempItem)) {
                combo.setSelectedItem(currentItem);
            } else {
                currentItem = tempItem;
            }
        }
    }
}