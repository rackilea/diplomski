public class TestTableEditor {

    public static void main(String[] args) {
        new TestTableEditor();
    }

    private JTable table;

    public TestTableEditor() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                table = new JTable(new MyTableModel());
                InputMap im = table.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
                ActionMap am = table.getActionMap();

                KeyStroke enterKey = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);

                im.put(enterKey, "Action.enter");
                am.put("Action.enter", new AbstractAction() {
                    public void actionPerformed(ActionEvent evt) {
                        table.changeSelection(table.getSelectedRow(), 1, false, false);
                        if (!table.editCellAt(table.getSelectedRow(), 1)) {
                            JOptionPane.showMessageDialog(table, "Failed to start cell editing");
                        }
                    }
                });

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class MyTableModel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return 1;
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Object value = null;
            switch (columnIndex) {
                case 0:
                    value = "Can't edit";
                    break;
                case 1:
                    value = "Edit me";
                    break;
                case 2:
                    value = "Can't edit";
                    break;
            }
            return value;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex == 1;
        }
    }
}