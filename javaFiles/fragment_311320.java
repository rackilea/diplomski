private void createGraphic(String textValue, Color color) {
    TeXFormula tex = new TeXFormula(textValue);
    java.awt.Image awtImage = tex.createBufferedImage(TeXConstants.STYLE_TEXT, 12, color, null);
    Image fxImage = SwingFXUtils.toFXImage((BufferedImage) awtImage, null);
    label.setGraphic(new ImageView(fxImage));
}