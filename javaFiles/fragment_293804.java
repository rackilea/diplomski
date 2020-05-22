public class ImageCellRenderer extends ImagePreviewPane implements ListCellRenderer {

    public ImageCellRenderer() {
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Color bg = null;
        Color fg = null;

        JList.DropLocation dropLocation = list.getDropLocation();
        if (dropLocation != null
                && !dropLocation.isInsert()
                && dropLocation.getIndex() == index) {

            bg = DefaultLookup.getColor(this, getUI(), "List.dropCellBackground");
            fg = DefaultLookup.getColor(this, getUI(), "List.dropCellForeground");

            isSelected = true;
        }

        if (isSelected) {
            setBackground(bg == null ? list.getSelectionBackground() : bg);
            setForeground(fg == null ? list.getSelectionForeground() : fg);
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        if (value instanceof ImagePreview) {
            ImagePreview ip = (ImagePreview) value;
            setImage(ip.getImage());
            setDescription(ip.getDescription());
        } else {
            setImage(null);
            setDescription("??");
        }

        setEnabled(list.isEnabled());
        setFont(list.getFont());

        return this;
    }

}