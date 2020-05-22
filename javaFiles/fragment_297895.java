xOffset = (int) (camera.getX() % (2 * WIDTH));

// draw the background image at x = xOffset - 2 * WIDTH
g.drawImage(bg, xOffset - 2 * WIDTH, 0, WIDTH, HEIGHT, null);
g.drawImage(bgInv, xOffset - WIDTH, 0, WIDTH, HEIGHT, null);

// draw the background image at x = xOffset
g.drawImage(bg, xOffset, 0, WIDTH, HEIGHT, null);
g.drawImage(bgInv, xOffset + WIDTH, 0, WIDTH, HEIGHT, null);