public class TestFilteredCellEditor {

    public static void main(String[] args) {
        new TestFilteredCellEditor();
    }

    public TestFilteredCellEditor() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new FilteredEditorPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class FilteredEditorPane extends JPanel {

        public FilteredEditorPane() {
            setLayout(new BorderLayout());
            JTable table = new JTable(new MyTableModel());
            TableColumnModel columnModel = table.getColumnModel();
            columnModel.getColumn(1).setCellEditor(new FilteredTableEditor());
            add(new JScrollPane(table));
        }
    }

    public class FilteredTableEditor extends AbstractCellEditor implements TableCellEditor {

        private JTextField editor;

        public FilteredTableEditor() {
            editor = new JTextField();
            ((AbstractDocument) editor.getDocument()).setDocumentFilter(new NumericDocumentFilter());
        }

        @Override
        public boolean isCellEditable(EventObject e) {
            return true;
        }

        @Override
        public Object getCellEditorValue() {
            return editor.getText();
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (value instanceof String) {
                editor.setText((String) value);
            } else {
                editor.setText(null);
            }
            return editor;
        }
    }

    public class NumericDocumentFilter extends DocumentFilter {

        public void insertString(DocumentFilter.FilterBypass fb, int offset,
                String string, AttributeSet attr)
                throws BadLocationException {

            StringBuilder buffer = new StringBuilder(string);
            boolean isBad = false;
            for (int i = buffer.length() - 1; i >= 0; i--) {
                char ch = buffer.charAt(i);
                if (!Character.isDigit(ch)) {
                    buffer.deleteCharAt(i);
                    isBad = true;
                }
            }
            if (isBad) {
                Toolkit.getDefaultToolkit().beep();
            }
            super.insertString(fb, offset, buffer.toString(), attr);
        }

        public void replace(DocumentFilter.FilterBypass fb,
                int offset, int length, String string, AttributeSet attr) throws BadLocationException {
            if (length > 0) {
                fb.remove(offset, length);
            }
            insertString(fb, offset, string, attr);
        }
    }

    public class MyTableModel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return 1;
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return "";
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return true;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return String.class;
        }
    }
}