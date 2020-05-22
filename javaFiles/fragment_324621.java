public class ImageCellRenderer extends DefaultListCellRenderer {

    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof ??) {
            ImageIcon icon = ...;
            setIcon(icon);
        }
        return this;
    }

}