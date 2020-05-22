public class Testing extends JFrame implements ItemListener{
    private static final long serialVersionUID = 1L;
        private JComboBox mainComboBox;
        private Hashtable<Object, Object> subItems = new Hashtable<Object, Object>();

        public Testing() {
            String[] items = {"","Select Item", "Color", "Shape", "Fruit", "Size"};
            mainComboBox = new JComboBox(items);
            mainComboBox.addItemListener(this);
            mainComboBox.setEditable(true);
            String[] subItems1 = {"Select Color", "Red", "Blue", "Green"};
            subItems.put(items[2], subItems1);
            String[] subItems2 = {"Select Shape", "Circle", "Square", "Triangle"};
            subItems.put(items[3], subItems2);
            String[] subItems3 = {"Select Fruit", "Apple", "Orange", "Banana"};
            subItems.put(items[4], subItems3);
            String[] subItems4 = {"Select Size", "Big", "Middle", "Small"};
            subItems.put(items[5], subItems4);
            DefaultTableModel model = new DefaultTableModel(new String[]{"Instrument Used","Method Title"},0);
            JTable table = new JTable(model);
            table.getColumn("Instrument Used").setCellEditor(new DefaultCellEditor(mainComboBox));
            //table.getColumn("Instrument Used").setCellRenderer(new MyComboBoxRenderer());
            table.getColumn("Method Title").setCellEditor(new MyComboBoxEditor());
            //table.getColumn("Method Title").setCellRenderer(new MyComboBoxRenderer());
            model.addRow(new String[]{""});
            model.addRow(new String[]{""});
            getContentPane().add(table, BorderLayout.CENTER);
        }

       public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                if (e.getSource() == mainComboBox) {
                    if (mainComboBox.getSelectedIndex() != 0) {
                        FirstDialog firstDialog = new FirstDialog(Testing.this,
                                mainComboBox.getSelectedItem().toString(), "Please wait,  Searching for ..... ");
                    }
                } 
            }
        }

        private class FirstDialog extends JDialog {

            private static final long serialVersionUID = 1L;

            FirstDialog(final Frame parent, String winTitle, String msgString) {
                super(parent, winTitle);
                //setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                JLabel myLabel = new JLabel(msgString);
                JButton bNext = new JButton("Stop Processes");
                add(myLabel, BorderLayout.CENTER);
                add(bNext, BorderLayout.SOUTH);
                bNext.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent evt) {
                        setVisible(false);
                    }
                });
                javax.swing.Timer t = new javax.swing.Timer(1000, new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                    }
                });
                t.setRepeats(false);
                t.start();
                setLocationRelativeTo(parent);
                setSize(new Dimension(400, 100));
                setVisible(true);
            }
        }

        public static void main(String[] args) {
            JFrame frame = new Testing();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }

    class MyComboBoxEditor extends AbstractCellEditor implements TableCellEditor, ItemListener {

            private JComboBox editorComboBox;

            public MyComboBoxEditor() {
                editorComboBox = new JComboBox();
            editorComboBox.addItemListener(this);
            }

            public Object getCellEditorValue()
            {
                return editorComboBox.getSelectedItem();
            }

            public Component getTableCellEditorComponent(JTable table,
                    Object value,
                    boolean isSelected,
                    int row,
                    int column)
            {
                // which instrument is selected?
                String instrument = (String) table.getValueAt(row, 0);
                String[] methods = (String[]) subItems.get(instrument);
                editorComboBox.setModel(new DefaultComboBoxModel(methods));
                editorComboBox.setSelectedItem(value);
                return editorComboBox;
            }

        public void itemStateChanged(ItemEvent e)
        {
            stopCellEditing();
        }
        }
}