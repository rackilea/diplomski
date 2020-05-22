jScrollPane.setLayout(new ScrollPaneLayout() {
    @Override
    public void layoutContainer(Container parent) {
        JScrollPane scrollPane = (JScrollPane) parent;
        scrollPane.setComponentOrientation(
            ComponentOrientation.RIGHT_TO_LEFT);
            super.layoutContainer(parent);
            scrollPane.setComponentOrientation(
                ComponentOrientation.LEFT_TO_RIGHT);
    }
});