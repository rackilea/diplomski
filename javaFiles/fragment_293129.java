public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::initGUI);
    }

    private static void initGUI() {
        JFrame frame = new JFrame("TableModel JProgressBar Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JScrollPane scroll = new JScrollPane();
        frame.getContentPane().add(scroll);

        final JTable table = new JTable();
        scroll.setViewportView(table);

        DefaultTableModel model = new DefaultTableModel() {
            public Class<?> getColumnClass(int column) {
                switch (column) {
                case 0:
                    return Boolean.class;
                case 1:
                    return String.class;
                case 2:
                    return Integer.class;  // !!!!
                default:
                    return String.class;
                }
            }
        };
        table.setModel(model);

        model.addColumn("Active");
        model.addColumn("Name");
        model.addColumn("Progress");

        table.getColumn("Progress").setCellRenderer(new ProgressCellRender());

        model.addRow(new Object[] { true, "aaaa", 14 });
        model.addRow(new Object[] { false, "bbbbbbbb", 0 });
        model.addRow(new Object[] { true, "ccccc", 2 });

        frame.pack();
        frame.setVisible(true);
    }
}