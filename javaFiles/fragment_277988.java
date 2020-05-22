public class LabelSyncer implements ListSelectionListener {

    private JLabel toSync;
    private int columnIndex;

    public LabelSyncer(JLabel toSync, int columnIndex) {

    }

    public void valueChanged(ListSelectionEvent e) {
        JTable table = (JTable) e.getSource();
        int row = table.getSelectedRow();
        toSync.setText(table.getModel().getValueAt(row, columnIndex).toString());
    }
}