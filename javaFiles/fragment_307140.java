// the color you want to find
// Set it to your desired value
Color myColorToMatch = new Color();
int w = bufferedImage.getWidth(null);
int h = bufferedImage.getHeight(null);
// find your pixel in the rgbs array
for(int y=0;y<h;y++) {
 for(int x=0;x<w;x++) {
  int pixel = image.getRGB(x, y);
  Color currentColor = new Color(pixel);

  if(currentColor.equals(myColorToMatch)) {
   robot.mouseMove(x, y);
   robot.mousePress(InputEvent.BUTTON1_MASK);
   robot.mouseRelease(InputEvent.BUTTON1_MASK);
  }
 }
}