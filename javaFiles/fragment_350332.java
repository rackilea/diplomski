Bitmap cs = null;
view.setDrawingCacheEnabled(true);
view.buildDrawingCache(true);
cs = Bitmap.createBitmap(view.getDrawingCache());
Canvas canvas = new Canvas(cs);
view.draw(canvas);
canvas.save();
view.setDrawingCacheEnabled(false);