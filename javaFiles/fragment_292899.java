if (isSelected) {
        setForeground(table.getSelectionForeground());
        super.setBackground(table.getSelectionBackground());
    }
    else {
        setForeground(table.getForeground());
        setBackground(table.getBackground());
    }