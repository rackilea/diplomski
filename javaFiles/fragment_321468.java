public NewJFrame() {
    initComponents();

    jTable1.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            l.setBorder(new LineBorder(Color.black, 1));

            l.setBackground(Color.GREEN);

            return l;
        }
    });
}