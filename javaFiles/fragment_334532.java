public void captureComponent(JComponent component, File imageFile) throws IOException {
    BufferedImage bufImage = new BufferedImage(component.getSize().width, component.getSize().height, BufferedImage.TYPE_INT_RGB);  
    component.paint(bufImage.createGraphics());   
    imageFile.createNewFile();  
    ImageIO.write(bufImage, "jpeg", imageFile);
}