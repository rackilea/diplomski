public class Statistics extends JPanel {
    private DefaultTableModel model

    public Statistics() {
       super(new GridLayout(1,0));
       model = new DefaultTableModel(data, columnNames);
       ...
    }

    public void addData(Object[] data) {
       model.addRow(data);
    }
}