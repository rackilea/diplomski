import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class SystemFontDisplayer extends JFrame {

    private static final long serialVersionUID = 1L;
    private JFrame frame = new JFrame("Nimbus UIDeafaults and Font");
    private JComboBox fontsBox;
    private javax.swing.Timer timer = null;
    private JButton testButton = new JButton("testButton");
    private JTextField testTextField = new JTextField("testTextField");
    private JLabel testLabel = new JLabel("testLabel");

    public SystemFontDisplayer() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontFamilyNames = ge.getAvailableFontFamilyNames();
        fontsBox = new JComboBox(fontFamilyNames);
        fontsBox.setSelectedItem(0);
        fontsBox.setRenderer(new ComboRenderer(fontsBox));
        fontsBox.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    final String fontName = fontsBox.getSelectedItem().toString();
                    fontsBox.setFont(new Font(fontName, Font.PLAIN, 16));
                    start();
                }
            }
        });
        fontsBox.setSelectedItem(0);
        fontsBox.getEditor().selectAll();
        frame.setLayout(new GridLayout(4, 0, 20, 20));
        frame.add(fontsBox);
        frame.add(testButton);
        frame.add(testTextField);
        frame.add(testLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(200, 105);
        frame.pack();
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                fontsBox.setPopupVisible(true);
                fontsBox.setPopupVisible(false);
            }
        });
        frame.setVisible(true);
    }

    private void start() {
        timer = new javax.swing.Timer(750, updateCol());
        timer.setRepeats(false);
        timer.start();
    }

    public Action updateCol() {
        return new AbstractAction("text load action") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                final Font fnt = new Font(fontsBox.getSelectedItem().toString(), Font.PLAIN, 12);
                final FontUIResource res = new FontUIResource(fnt);
                UIManager.getLookAndFeelDefaults().put("Button.font", res);
                UIManager.getLookAndFeelDefaults().put("TextField.font", res);
                UIManager.getLookAndFeelDefaults().put("Label.font", res);
                SwingUtilities.updateComponentTreeUI(frame);
            }
        };
    }

    public static void main(String arg[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                SystemFontDisplayer systemFontDisplayer = new SystemFontDisplayer();
            }
        });
    }

    private class ComboRenderer extends BasicComboBoxRenderer {

        private static final long serialVersionUID = 1L;
        private JComboBox comboBox;
        final DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
        private int row;

        private ComboRenderer(JComboBox fontsBox) {
            comboBox = fontsBox;
        }

        private void manItemInCombo() {
            if (comboBox.getItemCount() > 0) {
                final Object comp = comboBox.getUI().getAccessibleChild(comboBox, 0);
                if ((comp instanceof JPopupMenu)) {
                    final JList list = new JList(comboBox.getModel());
                    final JPopupMenu popup = (JPopupMenu) comp;
                    final JScrollPane scrollPane = (JScrollPane) popup.getComponent(0);
                    final JViewport viewport = scrollPane.getViewport();
                    final Rectangle rect = popup.getVisibleRect();
                    final Point pt = viewport.getViewPosition();
                    row = list.locationToIndex(pt);
                }
            }
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (list.getModel().getSize() > 0) {
                manItemInCombo();
            }
            final JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, row, isSelected, cellHasFocus);
            final Object fntObj = value;
            final String fontFamilyName = (String) fntObj;
            setFont(new Font(fontFamilyName, Font.PLAIN, 16));
            return this;
        }
    }
}