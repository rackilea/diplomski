/**
  * Create an instance of ImageIcon with the given path
  * @param path  String - path of the image
  * @return  ImageIcon - ImageIcon made with the image at the given path
  */
private ImageIcon createImageIcon(String path) {
    if (path != null) {
        URL tmp = getClass().getResource(path.replace("\\", "/"));
        if(tmp!=null)
            return new ImageIcon(tmp);
        else
            return new ImageIcon();
    } else {
        System.err.println("Couldn't find file: " + path);
        return null;
    }
}