ListCellRenderer<? super String> defaultRenderer = comboBox.getRenderer();
ListCellRenderer<String> modifiedRenderer = new ListCellRenderer<String>() {
    @Override
    public Component getListCellRendererComponent(JList<? extends String> list, String value, int index,
            boolean isSelected, boolean cellHasFocus) {
        Component component = defaultRenderer.getListCellRendererComponent(
                list, value, index, isSelected, cellHasFocus);
        component.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        return component;
    }
};
comboBox.setRenderer(modifiedRenderer);