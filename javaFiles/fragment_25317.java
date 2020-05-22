class FoodListRenderer extends DefaultListCellRenderer {

@Override
public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
    String name = ((MenuItem) value).foodName();
    return super.getListCellRendererComponent(list, name, index, isSelected, cellHasFocus);
}}