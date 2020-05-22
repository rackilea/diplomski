public class LabelRenderer extends DefaultTableCellRenderer {

    public static final Border focusedCellBorder = UIManager.getBorder("Table.focusCellHighlightBorder");

    public static final Border unfocusedCellBorder = createEmptyBorder();

    private static Border createEmptyBorder() {
        Insets i = focusedCellBorder.getBorderInsets(new JLabel());
        return BorderFactory.createEmptyBorder(i.top, i.left, i.bottom, i.right);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        String text = value.toString();

        try {
            setIcon(new ImageIcon(getClass().getResource("ok_16px.png")));
            // This below code setting the border to be highlighted, but not whole              

        } catch (Exception ex) {
            System.out.println(ex);
        }
        setBorder(hasFocus ? focusedCellBorder : unfocusedCellBorder);

        return this;
    }
}