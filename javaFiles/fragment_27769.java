import javax.swing.table.DefaultTableModel;

public class JTableModel {

    private DefaultTableModel model;

    private String[] columns = {"Group", "Alpha", "Beta", "Gamma"};

    private String[][] rows = {{"Group A", "all", "box", "game"},
            {"Group A", "apple", "band", "going"},
            {"Group B", "alabaster", "banquet", "ghost"},
            {"Group B", "alone", "boy", "ghoulish"}};

    public JTableModel() {
        this.model = new DefaultTableModel();
        this.model.setColumnIdentifiers(columns);
        setModelRows();
    }

    private void setModelRows() {
        String prevGroup = "";
        for (String[] row : rows) {
            if (row[0].equals(prevGroup)) {
                row[0] = " ";
            } else {
                prevGroup = row[0];
            }
            this.model.addRow(row);
        }
    }

    public DefaultTableModel getModel() {
        return model;
    }

}