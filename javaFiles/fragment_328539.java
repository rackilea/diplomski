public class JTableBooleanIcons {

    private JFrame frame;
    private DefaultTableModel tableModel;
    private JTable table;
    private ImageIcon yesIcon;
    private ImageIcon noIcon;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JTableBooleanIcons window = new JTableBooleanIcons();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public JTableBooleanIcons() {
        try {
            yesIcon = (new ImageIcon(ImageIO.read(BooleanIconRenderer.class.getResourceAsStream("/yes.png"))));
            noIcon = (new ImageIcon(ImageIO.read(BooleanIconRenderer.class.getResourceAsStream("/no.png"))));
        } catch (Exception e) {
            e.printStackTrace();
        }
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tableModel = new DefaultTableModel(new Object[]{"Words", "Pictures"}, 0);
        table = new JTable(tableModel);
        table.setRowHeight(40);
        tableModel.addRow(new Object[]{"click icon to change", false});
        tableModel.addRow(new Object[]{"click icon to change", true});
        tableModel.addRow(new Object[]{"click icon to change", false});
        tableModel.addRow(new Object[]{"click icon to change", true});
        tableModel.addRow(new Object[]{"click icon to change", false});
        tableModel.addRow(new Object[]{"click icon to change", true});
        tableModel.addRow(new Object[]{"click icon to change", false});
        tableModel.addRow(new Object[]{"click icon to change", true});

        frame.getContentPane().add(table, BorderLayout.CENTER);

        table.getColumn("Pictures").setCellRenderer(new BooleanIconRenderer());
        table.getColumn("Pictures").setCellEditor(new BooleanIconEditor());

    }

    @SuppressWarnings("serial")
    private class BooleanIconRenderer extends DefaultTableCellRenderer implements TableCellRenderer {

        public BooleanIconRenderer() {
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int col) {
            super.getTableCellRendererComponent(table, null, isSelected, hasFocus, row, col);
            if ((boolean) value) {
                setIcon(yesIcon);
            } else {
                setIcon(noIcon);
            }
            return this;
        }
    }

    @SuppressWarnings("serial")
    private class BooleanIconEditor extends AbstractCellEditor implements TableCellEditor, MouseListener {

        private BooleanComponent boolComp;
        private boolean isMouseEvent;

        public BooleanIconEditor() {
            boolComp = new BooleanComponent(false);
            boolComp.addMouseListener(this);
            InputMap im = boolComp.getInputMap(JComponent.WHEN_FOCUSED);
            ActionMap am = boolComp.getActionMap();

            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "click");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "click");

            am.put("click", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Clicked");
                    boolComp.setValue(!boolComp.getValue());
                }
            });

        }

        @Override
        public boolean isCellEditable(EventObject e) {
            isMouseEvent = e instanceof MouseEvent;
            return true; //(e instanceof MouseEvent);
        }

        @Override
        public Object getCellEditorValue() {
            return boolComp.getValue();
        }

        @Override
        public Component getTableCellEditorComponent(JTable table,
                Object value, boolean isSelected, int row, int column) {
            boolean state = (boolean) value;
            if (isMouseEvent) {
                state = !state;
            }
            boolComp.setValue(state);
            boolComp.setOpaque(isSelected);
            boolComp.setBackground(table.getSelectionBackground());
            return boolComp;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            this.fireEditingStopped();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            this.fireEditingStopped();

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            this.fireEditingStopped();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            this.fireEditingStopped();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            this.fireEditingStopped();
        }
    }

    @SuppressWarnings("serial")
    private class BooleanComponent extends JLabel {

        private boolean value;

        public BooleanComponent(boolean value) {
            this.value = value;
        }

        public boolean getValue() {
            return value;
        }

        public void setValue(boolean value) {
            this.value = value;
            if (value) {
                setIcon(yesIcon);
            } else{
                setIcon(noIcon);
            }
        }
    }
}