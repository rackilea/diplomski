// Set the base, start font
Font font = new Font("Arial", Font.BOLD, 12);
// Get rendering context
FontRenderContext context = graphics.getFontRenderContext();
// Set the font used by the graphics context...
graphics.setFont(font);
// Get the rectangle "bounds" of the text
Rectangle2D bounds = graphics.getFont().getStringBounds("Hello world", context);
// Get the line metrics, which describes things like the fonts decent and ascent
LineMetrics line = font.getLineMetrics(text, context);
// Calculate the scaling requirements
float xScale = (float) (region.width / bounds.getWidth());
float yScale = (region.height / (line.getAscent() + line.getDescent()));

// Calculate the offset for the text
double x = region.x;
double y = region.y + region.height - (yScale * line.getDescent());
// Create a new transformation, translating the x, y position
// This appears to be trying to place the text at the bottom
// left position of the region, but the problem is, this then gets
// scaled, when means that this translation is no longer the same...   
AffineTransform transformation = AffineTransform.getTranslateInstance(x, y);

// Apply a scale...
if (xScale > yScale)
    transformation.scale(yScale, yScale);
else
    transformation.scale(xScale, xScale);

// Create a new instance of the font using the transformation
graphics.setFont(font.deriveFont(transformation));
// Make it look pretty
graphics.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);

// Render the font within the region...
int centerX = region.width / 2;
int centerY = region.height / 2;
graphics.drawString(text, centerX, centerY - (int) bounds.getHeight());