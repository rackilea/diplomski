String gifFilename = "testgif.gif";
    URL url = getClass().getResource(gifFilename);
    ImageInputStream iis = new FileImageInputStream(new File(url.toURI()));
    ImageReader reader = ImageIO.getImageReadersByFormatName("GIF").next();
    // (reader is actually a GIFImageReader plugin)
    reader.setInput(iis);
    int total = reader.getNumImages(true);
    System.out.println("Total images: "+total);
    BufferedImage[] imgs = new BufferedImage[total];

    for (int i = 0; i < total; i++) {
        imgs[i] = reader.read(i);
        Icon icon = new ImageIcon(imgs[i]);
        // JLabel l = new JLabel(icon));
    }