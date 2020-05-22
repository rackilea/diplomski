public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
    setFont(list.getFont());

    if (index == -1 && selectionManager.getSelectedItems().size() > 0) {
        StringBuffer firstItem = new StringBuffer();
        for (Object sel : selectionManager.getSelectedItems()) {
            firstItem.append(sel + "; ");
        }
        if (firstItem.toString().endsWith("; ")) {
            firstItem.deleteCharAt(firstItem.length() - 2);
        }
        setText((value == null) ? "" : firstItem.toString());
    } else {// other items
        setText((value == null) ? "" : value.toString());
    }

    return this;
}