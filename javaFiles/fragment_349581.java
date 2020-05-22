public class TestGetColumnWidths {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Columns");
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                final JTable table = new JTable(5, 6);
                table.getTableHeader().addComponentListener(new ComponentAdapter() {
                    @Override
                    public void componentResized(ComponentEvent e) {
                        super.componentResized(e);
                        displayColumnWidths(table.getTableHeader());
                    }
                });
                JPanel panel = new JPanel(new BorderLayout());
                panel.add(new JScrollPane(table));

                frame.add(panel);
                //frame.pack();
                frame.setSize(1000, 250);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

            private void displayColumnWidths(JTableHeader header) {
                TableColumnModel model = header.getColumnModel();

                for (int i = 0; i < model.getColumnCount(); i++) {
                    TableColumn column = model.getColumn(i);
                    System.err.println("column.getWidth(): " + column.getWidth());
                }
            }
        });
    }
}