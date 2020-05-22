BufferedImage image = new BufferedImage(16, 16, BufferedImage.TYPE_BYTE_BINARY);

    image.setRGB(0, 0, 0xFFFFFFFF);
    image.setRGB(1, 0, 0xFF000000);
    image.setRGB(0, 1, 0xFF000000);
    image.setRGB(1, 1, 0xFFFFFFFF);

    System.out.println(image.getRGB(0, 0));
    System.out.println(image.getRGB(1, 0));
    System.out.println(image.getRGB(0, 1));
    System.out.println(image.getRGB(1, 1));

    int[] array = image.getRGB(0, 0, image.getWidth(), image.getHeight(), null, 0, image.getWidth());
    System.out.println(array[0]); // at (0,0)
    System.out.println(array[1]); // at (1,0)
    System.out.println(array[16]); // at (0,1)
    System.out.println(array[17]); // at (1,1)