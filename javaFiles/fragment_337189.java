PDAnnotationFileAttachment txtLink = new PDAnnotationFileAttachment();
txtLink.setFile(fs);
// Set the rectangle containing the link
int offsetX = 20;
int offsetY = 600;
PDRectangle position = new PDRectangle();
position.setLowerLeftX(offsetX);
position.setLowerLeftY(offsetY);
position.setUpperRightX(offsetX + 20);
position.setUpperRightY(offsetY + 20);
txtLink.setRectangle(position);

PDAppearanceDictionary appearanceDictionary = new PDAppearanceDictionary();
PDAppearanceStream appearanceStream = new PDAppearanceStream(doc);
appearanceStream.setResources(new PDResources());
PDRectangle bbox = new PDRectangle(txtLink.getRectangle().getWidth(), txtLink.getRectangle().getHeight());
appearanceStream.setBBox(bbox);
try (PDPageContentStream cs = new PDPageContentStream(doc, appearanceStream))
{
    PDImageXObject image = PDImageXObject.createFromFile("image.jpg", doc);
    cs.drawImage(image, 0, 0);
}
appearanceDictionary.setNormalAppearance(appearanceStream);
txtLink.setAppearance(appearanceDictionary);

page.getAnnotations().add(txtLink);