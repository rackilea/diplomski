public void clipChildren(Region region) {
    final Rectangle clipPane = new Rectangle();
    region.setClip(clipPane);

    region.layoutBoundsProperty().addListener((ov, oldValue, newValue) -> {
        clipPane.setWidth(newValue.getWidth());
        clipPane.setHeight(newValue.getHeight());
    });
}