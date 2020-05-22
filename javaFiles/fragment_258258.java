BufferedImage image = ImageIO.read(new URL("http://i.stack.imgur.com/QaTj5.jpg"));
    int startPos = 0, lastValue = 0;
    Set<Integer> colours = new HashSet<>();
    for (int x = 0; x < image.getWidth(); x++) {
        int histValue = 0;

        for (int y = 0; y < image.getHeight(); y++) {
            colours.add(image.getRGB(x, y) );
            if (image.getRGB(x, y) == 0xffffFFFF) {
                histValue++;
            }
        }

        if (histValue == 0 && lastValue == 0) {
            startPos = x;
        } else if (histValue == 0 && lastValue != 0) {
            BufferedImage segment = image.getSubimage(startPos, 0, x
                    - startPos, image.getHeight());
            ImageIO.write(segment, "jpg", new File("Segment" + startPos
                    + ".jpg"));

        }
        lastValue = histValue; 
    }
    if (lastValue!=0){
        BufferedImage segment = image.getSubimage(startPos, 0, image.getWidth()
                - startPos, image.getHeight());
        ImageIO.write(segment, "jpg", new File("Segment" + startPos
                + ".jpg"));
    }