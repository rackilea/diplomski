class CustomRenderer implements ListCellRenderer
{

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {

        JLabel label = new JLabel();
        label.setFont(((Font) value).deriveFont(12f));
        label.setText(((Font) value).getFontName());
        return label;
    }

}