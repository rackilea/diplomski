/* imageType should be one of the variants that includes alpha  */
final BufferedImage composited = new BufferedImage(width, height, imageType);
final Graphics graphics = composited.getGraphics();
for (final Image layer : layers) {
  /* draw the image at 0,0 */
  graphics.drawImage(layer, 0, 0, null);
}
graphics.dispose();