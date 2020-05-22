import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import javax.swing.text.Document;
import javax.swing.table.TableRowSorter;

public class FontFilter {

    private JComponent ui = null;
    JTextField filterText;
    TableRowSorter sorter;

    FontFilter(boolean listLike) {
        initUI(listLike);
    }

    public void initUI(boolean listLike) {
        if (ui != null) {
            return;
        }

        ui = new JPanel(new BorderLayout(4, 4));
        ui.setBorder(new EmptyBorder(4, 4, 4, 4));

        GraphicsEnvironment ge
                = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fonts = ge.getAvailableFontFamilyNames();
        String[][] tableData = new String[fonts.length][1];
        for (int i = 0; i < fonts.length; i++) {
            tableData[i][0] = fonts[i];
        }
        String[] header = {"Fonts"};
        JTable table = new JTable(tableData, header);
        if (listLike) {
            Dimension d = table.getPreferredScrollableViewportSize();
            table.setPreferredScrollableViewportSize(new Dimension(d.width/2,d.height));
            table.setShowGrid(false);
            table.setTableHeader(null);
            table.setFillsViewportHeight(true);
        }
        ui.add(new JScrollPane(table));
        sorter = new TableRowSorter(table.getModel());
        table.setRowSorter(sorter);

        filterText = new JTextField(10);
        ui.add(filterText, BorderLayout.PAGE_START);
        Document doc = filterText.getDocument();
        DocumentListener listener = new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                newFilter();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                newFilter();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                newFilter();
            }
        };
        doc.addDocumentListener(listener);
    }

    private void newFilter() {
        RowFilter rf = null;
        //If current expression doesn't parse, don't update.
        try {
            rf = RowFilter.regexFilter(filterText.getText(), 0);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
                FontFilter o1 = new FontFilter(true);
                FontFilter o2 = new FontFilter(false);

                JFrame f = new JFrame("Font Filter");
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                f.add(o1.getUI(), BorderLayout.LINE_START);
                f.add(o2.getUI(), BorderLayout.CENTER);
                f.pack();
                f.setMinimumSize(f.getSize());

                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}