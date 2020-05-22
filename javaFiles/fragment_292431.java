{
    if (value instanceof YourClass) {
        YourClass ob = (YourClass) value;
        return super.getListCellRendererComponent(list, ob.getProperty(), index, isSelected, cellHasFocus);
    }
    return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
}