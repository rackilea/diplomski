// Create a drawable
GradientDrawable shape = new GradientDrawable();
// Get the screen size
Display display = getWindowManager().getDefaultDisplay();
Point size = new Point();
display.getSize(size);
int width = size.x;
int height = size.y;
// Do some math to get the radius value to scale
int radius = (int) Math.round(width * height / 100000);
// Set the corner radius
shape.setCornerRadius(radius);
// Apply shape as background
setBackground(shape);