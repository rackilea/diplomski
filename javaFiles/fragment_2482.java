private class MyRenderer implements ListCellRenderer {
    public int listSelectedIndex = -1;

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
            boolean cellHasFocus) {
        if (index == listSelectedIndex)
            return new Yeah(isSelected);
        else
            return new Oh();
    }
}
MyRenderer lcr = new MyRenderer();
private class MyListUI extends BasicListUI {

    public void triggerUpdate() {
        lcr.listSelectedIndex = list.getSelectedIndex();
        updateLayoutState();
        list.revalidate();
    }
}