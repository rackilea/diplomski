public class MyTatbleEditor {

    public static void main(String[] args) {
        new MyTatbleEditor();
    }

    public MyTatbleEditor() {
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
                frame.setSize(200, 200);
                frame.setLocationRelativeTo(null);
                frame.setLayout(new BorderLayout());

                Vector rows = new Vector();
                for (int index = 0; index < 10; index++) {
                    Vector data = new Vector();
                    data.add(new Object());
                    rows.add(data);
                }
                Vector cols = new Vector();
                cols.add("One");
                DefaultTableModel model = new DefaultTableModel(rows, cols);

                JTable table = new JTable(model);

                table.getColumn("One").setCellEditor(new MyTableButtonEditor());
                table.getColumn("One").setCellRenderer(new MyTableButtonRenderer());

                frame.add(new JScrollPane(table));

                frame.setVisible(true);


            }
        });
    }

    protected class MyTableButtonEditor extends AbstractCellEditor implements TableCellEditor {

        private JButton button;
        private int column;
        private int row;

        public MyTableButtonEditor() {
            button = new JButton("Click me if you dare");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            JOptionPane.showMessageDialog(button, "How dare you :(", "Fancy that", JOptionPane.INFORMATION_MESSAGE);
                        }
                    });
                }
            });
        }

        @Override
        public boolean isCellEditable(EventObject e) {
            boolean isEditable = false;
            if (e instanceof MouseEvent) {
                MouseEvent me = (MouseEvent) e;
                if (me.getButton() == MouseEvent.BUTTON1 && me.getID() == MouseEvent.MOUSE_PRESSED) {
                    isEditable = true;
                }
            } else if (e instanceof KeyEvent) {
                KeyEvent ke = (KeyEvent) e;
                if (ke.getID() == KeyEvent.KEY_PRESSED && (ke.getKeyCode() == KeyEvent.VK_SPACE || ke.getKeyCode() == KeyEvent.VK_ENTER)) {
                    isEditable = true;
                }
            }
            return isEditable;
        }

        @Override
        public Object getCellEditorValue() {
            return new Object();
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (isSelected) {
                button.requestFocus();
            }
            this.column = column;
            this.row = row;
            return button;
        }
    }

    protected class MyTableButtonRenderer implements TableCellRenderer {

        private JButton button;

        public MyTableButtonRenderer() {
            button = new JButton("Click me if you dare");
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return button;
        }

    }
}