try {
        File imagefile = new File("C:/pics/1206.jpg");
        image = ImageIO.read(imagefile);


        ImageIO.write(image, "jpg",new File("C:/pics"));
        ImageIO.write(image, "bmp",new File("C:/pics"));
        ImageIO.write(image, "gif",new File("C:/picsf"));
        ImageIO.write(image, "png",new File("C:/pics"));
  } catch (IOException ex) {
        ex.printStackTrace();
  }