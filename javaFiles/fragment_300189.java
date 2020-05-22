// Assumed that these are non-null
BufferedImage bigIcon, smallIcon;

// Create a new image.
BufferedImage finalIcon = new BufferedImage(
    bigIcon.getWidth(), bigIcon.getHeight(),
    BufferedImage.TYPE_INT_ARGB)); // start transparent

// Get the graphics object. This is like the canvas you draw on.
Graphics g = finalIcon.getGraphics();

// Now we draw the images.
g.drawImage(bigIcon, 0, 0, null); // start at (0, 0)
g.drawImage(smallIcon, 10, 10, null); // start at (10, 10)

// Once we're done drawing on the Graphics object, we should
// call dispose() on it to free up memory.
g.dispose();

// Finally, convert to ImageIcon and apply.
imageLabel.setIcon(new ImageIcon(finalIcon));