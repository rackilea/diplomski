private static class BorderLessTableCellRenderer extends DefaultTableCellRenderer {

    private static final long serialVersionUID = 1L;

    public Component getTableCellRendererComponent(
            final JTable table,
            final Object value,
            final boolean isSelected,
            final boolean hasFocus,
            final int row,
            final int col) {

        final boolean showFocusedCellBorder = false; // change this to see the behavior change

        final Component c = super.getTableCellRendererComponent(
                table,
                value,
                isSelected,
                showFocusedCellBorder && hasFocus, // shall obviously always evaluate to false in this example
                row,
                col
        );
        return c;
    }
}