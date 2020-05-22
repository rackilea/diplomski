try (ImageInputStream input = ImageIO.createImageInputStream(new File(fileName))) {
    j2kImageReader.setInput(input));

    // Not sure why/if you want to read only the upper left, but I'll leave it as is
    ImageReadParam imageReadParam = j2kImageReader.getDefaultReadParam();
    imageReadParam.setSourceRegion(new Rectangle(0, 0, 300, 300)); 

    // Use read instead of readAll
    BufferedImage image = j2kImageReader.read(0, imageReadParam); 

    // You can now create an icon and add to a component
    Icon icon = new ImageIcon(image);
    JLabel label = new JLabel(icon);

    // Etc...
}