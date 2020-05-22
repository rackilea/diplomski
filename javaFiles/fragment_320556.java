// Safe viewable area for default screen
Rectangle bounds = getScreenViewableBounds(null);
int x = bounds.x + ((bounds.width - getWidth());
int y = bounds.y + ((bounds.width - getHeight());

setLocation(x, y);