EditText ed;
.
.
.
.
.   
ed.setDrawingCacheEnabled(true);
Bitmap b = ed.getDrawingCache();
canvas.drawBitmap(bitmap, l, t, r, b, null);