/**
 * Creates and returns an ImageIcon from the resource in jar.
 * @param location resource location in the jar,
 * like 'com/example/GreatApp/res/icon.png' or null if it was not found.
 */
public ImageIcon createImageIconFromResource(String location)
           throws java.io.IOException {
  java.io.InputStream input = getClassLoader().getResourceAsStream(
               location);
  // or throw an ioexception here aka `file not found`
  if(input == null) return null;
  return new ImageIcon(ImageIO.read(input));
}