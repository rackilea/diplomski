public class TestColumnWidths {

    private static JTable mainTable;
    private static Random random = new Random();
    private static List<Data> data;

    private static class Data {

        String name;
        String surname;

        private Data(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                data = stubProvider();

                final JFrame frame = new JFrame("table adjust example");
                frame.add(createUI());
                frame.pack();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                update();
//                    java.util.Timer timer = new java.util.Timer();
//                    timer.schedule(new TimerTask() {
//                        @Override
//                        public void run() {
//                            update();
//                        }
//                    }, 3000, 3000);

                javax.swing.Timer timer = new javax.swing.Timer(3000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        update();
                    }
                });
                timer.setRepeats(true);
                timer.setCoalesce(true);
                timer.start();

            }
        });
    }

    private static JPanel createUI() {
        JPanel jPanel = new JPanel();
        mainTable = new JTable(2, 3);
        mainTable.setModel(new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return data.size();
            }

            @Override
            public int getColumnCount() {
                return 2;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Data dataItem = data.get(rowIndex);
                if (columnIndex == 0) {
                    return dataItem.name;
                }
                if (columnIndex == 1) {
                    return dataItem.surname;
                }
                throw new IllegalStateException();
            }
        });
        mainTable.setGridColor(Color.black);
        mainTable.setShowHorizontalLines(false);
        mainTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        final TableCellRenderer defaultRenderer = mainTable.getTableHeader().getDefaultRenderer();
        mainTable.getTableHeader().setDefaultRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jTable, Object o, boolean b, boolean b1, int row, int column) {
                JLabel parent = (JLabel) defaultRenderer.getTableCellRendererComponent(jTable, o, b, b1, row, column);
                if (column == 0) {
                    parent.setText("name");
                } else {
                    parent.setText("surname");
                }
                return parent;
            }
        });

//            jPanel.add(mainTable.getTableHeader());
//            jPanel.add(mainTable);

        jPanel.setLayout(new BorderLayout());
        jPanel.add(new JScrollPane(mainTable));

        return jPanel;
    }

    private static void update() {
        System.out.println("updating");
        data = stubProvider();

        adjustJTableRowSizes(mainTable);
        for (int i = 0; i < mainTable.getColumnCount(); i++) {
            adjustColumnSizes(mainTable, i, 2);
        }
    }

    private static void adjustJTableRowSizes(JTable jTable) {
        for (int row = 0; row < jTable.getRowCount(); row++) {
            int maxHeight = 0;
            for (int column = 0; column < jTable.getColumnCount(); column++) {
                TableCellRenderer cellRenderer = jTable.getCellRenderer(row, column);
                Object valueAt = jTable.getValueAt(row, column);
                Component tableCellRendererComponent = cellRenderer.getTableCellRendererComponent(jTable, valueAt, false, false, row, column);
                int heightPreferable = tableCellRendererComponent.getPreferredSize().height;
                maxHeight = Math.max(heightPreferable, maxHeight);
            }
            jTable.setRowHeight(row, maxHeight);
        }

    }

    public static void adjustColumnSizes(JTable table, int column, int margin) {
        DefaultTableColumnModel colModel = (DefaultTableColumnModel) table.getColumnModel();
        TableColumn col = colModel.getColumn(column);
        int width;

        TableCellRenderer renderer = col.getHeaderRenderer();
        if (renderer == null) {
            renderer = table.getTableHeader().getDefaultRenderer();
        }
        Component comp = renderer.getTableCellRendererComponent(
                table, col.getHeaderValue(), false, false, 0, 0);
        width = comp.getPreferredSize().width;

        for (int r = 0; r < table.getRowCount(); r++) {
            renderer = table.getCellRenderer(r, column);
            comp = renderer.getTableCellRendererComponent(
                    table, table.getValueAt(r, column), false, false, r, column);
            int currentWidth = comp.getPreferredSize().width;
            width = Math.max(width, currentWidth);
        }

        width += 2 * margin;

        col.setPreferredWidth(width);
    }

    private static List<Data> stubProvider() {
        List<Data> data = new ArrayList<Data>();
        for (int i = 0; i < 4; i++) {
            data.add(new Data(
                    "<html>"
                    + "<div>"
                    + "<span style='font-size: 15px'>Jason</span>"
                    + "<span style='font-size: 15px'>" + random.nextInt() + "</span>"
                    + "</div>"
                    + "</html>",
                    "Statham " + random.nextInt()));
        }
        return data;
    }
}