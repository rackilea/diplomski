public String readCustomData(byte[] imageData, String key) throws IOException{
    ImageReader imageReader = ImageIO.getImageReadersByFormatName("png").next();

    imageReader.setInput(ImageIO.createImageInputStream(new ByteArrayInputStream(imageData)), true);

    // read metadata of first image
    IIOMetadata metadata = imageReader.getImageMetadata(0);

    //this cast helps getting the contents
    PNGMetadata pngmeta = (PNGMetadata) metadata; 
    NodeList childNodes = pngmeta.getStandardTextNode().getChildNodes();

    for (int i = 0; i < childNodes.getLength(); i++) {
        Node node = childNodes.item(i);
        String keyword = node.getAttributes().getNamedItem("keyword").getNodeValue();
        String value = node.getAttributes().getNamedItem("value").getNodeValue();
        if(key.equals(keyword)){
            return value;
        }
    }
    return null;
}