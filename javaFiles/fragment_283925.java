public Component getTableCellRendererComponent(
                        JTable table, Object color,
                        boolean isSelected, boolean hasFocus,
                        int row, int column) {
    Color newColor = (Color)color;
    setBackground(newColor);
    if (isBordered) {
        if (isSelected) {
            ...
            //selectedBorder is a solid border in the color
            //table.getSelectionBackground().
            setBorder(selectedBorder);
        } else {
            ...
            //unselectedBorder is a solid border in the color
            //table.getBackground().
            setBorder(unselectedBorder);
        }
    }