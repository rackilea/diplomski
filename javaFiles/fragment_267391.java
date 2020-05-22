Drawable d = DrawableUtils.resizeImageToDrawable(
                    MapViewFragment.mapViewActivity,
                    Configuration.Display.getDrawableFix(i),
                    Configuration.MapView.getWaypointIconWidth(),
                    Configuration.MapView.getWaypointIconHeight());
d.setColorFilter(color, Mode.MULTIPLY);

Bitmap b = ((BitmapDrawable) d).getBitmap();
Canvas myCanvas = new Canvas(b);

int myColor = b.getPixel(0,0);
ColorFilter filter = new LightingColorFilter(myColor, color);