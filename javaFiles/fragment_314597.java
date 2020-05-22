class MyRenderer extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row,
            int column) {
        Component c = super.getTableCellRendererComponent(table,
                value, isSelected, hasFocus, row, column);
        c.setBackground(getColor((Integer) value));
        return c;
    }

    private Color getColor(int value) {
        switch(value){
        case 1: return Color.RED;
        case 2: return Color.GREEN;
        //TODO the rest of colors
        }
        return Color.DARK_GRAY;
    }
}