public class TableDemo extends JPanel {
    private boolean DEBUG = true;
    private JTable table;

    public TableDemo() {
        super(new GridLayout(1,0));

        table = new JTable(new MyTableModel());
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane);
    }

    // Rest of code