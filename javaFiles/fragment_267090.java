/** @see https://stackoverflow.com/a/14429388/230513 */
public class TableListenerTest {

    private static final int N = 8;
    private JFrame frame;
    private JScrollPane scrollPane;
    private JTable table;
    private DefaultTableModel tableModel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                TableListenerTest window = new TableListenerTest();
                window.frame.setVisible(true);
            }
        });
    }

    public TableListenerTest() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
        tableModel = new DefaultTableModel(new Object[]{"Stuff"}, 0);
        for (int i = 0; i < N; i++) {
            tableModel.addRow(new Object[]{"new row"});
        }
        table = new JTable(tableModel) {

            @Override
            public Dimension getPreferredScrollableViewportSize() {
                return new Dimension(200, table.getRowHeight() * N);
            }
        };
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        JButton btnAddRow = new JButton(new AbstractAction("Add Row") {

            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.addRow(new Object[]{"new row"});
                int last = table.getModel().getRowCount() - 1;
                Rectangle r = table.getCellRect(last, 0, true);
                table.scrollRectToVisible(r);
            }
        });
        frame.add(scrollPane);
        frame.add(btnAddRow);
        frame.pack();
    }
}