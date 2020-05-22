public void setRippleColor(Color color) {
    if (getSkin() == null) {
        createDefaultSkin();
    }
    SkinBase skin = (SkinBase) getSkin();
    Shape shape = (Shape) skin.getChildren().get(0);
    shape.setFill(color);
}