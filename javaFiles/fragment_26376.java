public Component getTableCellRendererComponent(JTable table,
                                               Object value, boolean isSelected,
                                               boolean hasFocus, int row,
                                               int column) {

    // need to be added
    setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
    setForeground(isSelected ? table.getSelectionForeground() : table.getForeground());
    //-------------
    setFont(table.getFont());
    setValue(value);

    int pos = 0;

    String pattern = params.getHighlightTxt();

    //if (len > last) {
    if (StringUtils.isNotBlank(pattern) && !pattern.equals("search message")) {
        while ((pos = value.toString().indexOf(pattern, pos)) >= 0) {
            try {
                //high.addHighlight(first, last, highlight_painter);
                high.addHighlight(pos, pos + pattern.length(), highlight_painter);
                pos += pattern.length();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    return this;
}