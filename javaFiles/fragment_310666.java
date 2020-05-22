public class DialogOne extends JDialog {
    private DefaultTableModel model;
    private JTable table;

    public DialogOne(JFrame frame, boolean modal, DefaultTableModel model) {
        super(frame, modal);
        this.model = model;
        table = new JTable();
        table.setModel(model);
    }

    public void dane() {
        ...
        model.addRow(...);
    }
}