/**
  * Loads and returns an {@link Image} resource. 
  * @param fileName name of the image resource.
  * @return Image as resource.
  */
  public Image getResourceImage(String fileName) {
      String imageDirectory = "images/";
      URL imgURL = getClass().getResource(imageDirectory + fileName);
      Image image = null;
      try {
         image = ImageIO.read(imgURL);
       } catch (IOException e) {}
      return image;
    }