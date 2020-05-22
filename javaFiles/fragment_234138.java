import java.awt.Dialog.ModalityType;
import java.awt.event.ItemEvent;
import java.io.File;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public class FolderTableExample extends JPanel {
    private static final int PREF_W = 250;
    private static final int PREF_H = 300;
    private static final int[] COL_WIDTHS = {45, 45, 100}; 
    private MyTableModel myTableModel = new MyTableModel();
    private JTable table = new JTable(myTableModel);
    private JCheckBox all = new JCheckBox("Select All");

    public FolderTableExample(String... options) {
        super(new BorderLayout());
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        topPanel.add(all);
        all.addItemListener(itemEvent -> {
            boolean selection = itemEvent.getStateChange() == ItemEvent.SELECTED;
            for (int i = 0; i < myTableModel.getRowCount(); i++) {
                myTableModel.setValueAt(selection, i, 0);
            }
        });

        table.setTableHeader(null);

        javax.swing.JFileChooser fc = new javax.swing.JFileChooser();
        Icon icon = fc.getUI().getFileView(fc).getIcon(new File("."));
        for (String option : options) {
            Object[] row = {Boolean.FALSE, icon, option};
            myTableModel.addRow(row);
        }

        table.setRowHeight(25);
        table.setFont(table.getFont().deriveFont(Font.BOLD));
        table.setShowGrid(false);
        TableColumnModel columnModel = table.getColumnModel();
        for (int i = 0; i < COL_WIDTHS.length; i++) {
            columnModel.getColumn(i).setMaxWidth(COL_WIDTHS[i]);
        }

        JPanel wrapperPanel = new JPanel(new BorderLayout());
        wrapperPanel.add(table, BorderLayout.PAGE_START);
        add(topPanel, BorderLayout.PAGE_START);
        add(new JScrollPane(wrapperPanel));
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private class MyTableModel extends DefaultTableModel {
        public MyTableModel() {
            super(new Object[] { "", "", "" }, 0);
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
            case 0:
                return Boolean.class;
            case 1:
                return Icon.class;
            default:
                return super.getColumnClass(columnIndex);
            }
        }
    }

    private static void createAndShowGui() {
        String[] array = new String[] { "Bananas", "Oranages", "Apples", "Pears", "Bananas",
                "Oranages", "Apples", "Pears", "Bananas", "Oranages", "Apples", "Pears", "Bananas",
                "Oranages", "Apples", "Pears", "Bananas", "Oranages", "Apples", "Pears" };
        FolderTableExample mainPanel = new FolderTableExample(array);

        JDialog dialog = new JDialog((JFrame) null, "Example", ModalityType.MODELESS);
        dialog.getContentPane().add(mainPanel);
        dialog.setResizable(false);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}