// load the image

BufferedImage originalImage = ImageIO.read(...);

// create the polygon

Polygon polygon = new Polygon();
polygon.addPoint(50, 50);
polygon.addPoint(150, 50);
polygon.addPoint(250, 150);
polygon.addPoint(150, 150);

Rectangle bounds = polygon.getBounds();

// create a transparent clipped image based on the bounds of the Polygon

BufferedImage clippedImage = new BufferedImage(bounds.width, bounds.height, BufferedImage.TYPE_INT_ARGB);
Graphics2D g = clippedImage.createGraphics();

polygon.translate(-bounds.x, -bounds.y);
g.setClip(polygon);
g.drawImage(originalImage, -bounds.x, -bounds.y, null);

// save the clipped image

ImageIO.write(...);