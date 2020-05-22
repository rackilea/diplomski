// Base font
Font font = new Font("Arial", Font.BOLD, 12);
// Get the fonts metrics
FontMetrics fm = g2d.getFontMetrics(font);

// Calculate the scaling requirements
float xScale = (float) (region.width / fm.stringWidth(text));
float yScale = (region.height / fm.getHeight());

// Determine which access to scale on...
float scale = 0f;
if (xScale > yScale) {
    scale = yScale;
} else {
    scale = xScale;
}

// Create a new font using the scaling facter
g2d.setFont(font.deriveFont(AffineTransform.getScaleInstance(scale, scale)));
// Make it pretty
g2d.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);

// Get the "scaled" metrics
fm = g2d.getFontMetrics();

// Position the text at the left, bottom position of the
// specified region...
int x = 0;
int y = (region.height - fm.getHeight()) + fm.getAscent();
g2d.drawString(text, x, y);