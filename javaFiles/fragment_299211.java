import java.awt.BorderLayout;
import java.text.Normalizer;
import javax.swing.BorderFactory;
import javax.swing.DefaultRowSorter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * @author dic19
 */
public class Demo {

    private JTable table;
    private JTextField textField;

    private void createAndShowGui() {

        textField = new JTextField(20);
        textField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(final DocumentEvent e) {
                Demo.this.filterTable(textField.getText());
            }

            @Override
            public void insertUpdate(final DocumentEvent e) {
                Demo.this.filterTable(textField.getText());
            }

            @Override
            public void changedUpdate(final DocumentEvent e) {
                Demo.this.filterTable(textField.getText());
            }
        });

        String[] header = new String[] {"Foreign text", "English text"};
        DefaultTableModel model = new DefaultTableModel(header, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return String.class;
            }
        };

        model.addRow(new Object[]{"šing", "wamg"});
        model.addRow(new Object[]{"čamg", "bung"});
        model.addRow(new Object[]{"búng", "sing"});
        model.addRow(new Object[]{"wámg", "camg"});

        table = new JTable(model);
        table.setAutoCreateRowSorter(true);

        JPanel filterPanel = new JPanel();
        filterPanel.add(new JLabel("Filter text:"));
        filterPanel.add(textField);

        JPanel content = new JPanel(new BorderLayout(8, 8));
        content.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        content.add(filterPanel, BorderLayout.PAGE_START);
        content.add(new JScrollPane(table), BorderLayout.CENTER);

        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(content);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

    }

    private void filterTable(final String query) {

        RowFilter<TableModel, Integer> filter = null;

        if (query.length() > 0) {
            filter = new RowFilter<TableModel, Integer>() {
                @Override
                public boolean include(RowFilter.Entry<? extends TableModel, ? extends Integer> entry) {

                    // Normalize the query string.
                    String normalizedQuery = Normalizer.normalize(query, Normalizer.Form.NFD);
                    normalizedQuery = normalizedQuery.replaceAll("[^\\x00-\\x7F]", "");

                    for (int i = 0; i < entry.getValueCount(); i++) {
                       // Get both the string value and its normalized string
                       String stringValue = entry.getStringValue(i);
                       String normalizedStringValue = Normalizer.normalize(stringValue, Normalizer.Form.NFD);
                       normalizedStringValue = normalizedStringValue.replaceAll("[^\\x00-\\x7F]", "");

                       // Two cases need to be evaluated here:
                       // 1. The normalized string value contains the normalized query string.
                       // 2. The string value contains the query string.
                       if (normalizedStringValue.contains(normalizedQuery) || stringValue.contains(query)) {
                           return true;
                       }
                   }
                   return false;
                }

            };
        }
        ((DefaultRowSorter)table.getRowSorter()).setRowFilter(filter);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Demo().createAndShowGui();
            }
        });
    }

}