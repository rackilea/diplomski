// lets create a new empty bitmap
Bitmap newBitmap = Bitmap.createBitmap(originalBitmap.getWidth(), originalBitmap.getHeight(), Bitmap.Config.ARGB_8888);
// create a canvas where we can draw on
Canvas canvas = new Canvas(newBitmap);
// create a paint instance with alpha
Paint alphaPaint = new Paint();
alphaPaint.setAlpha(42);
// now lets draw using alphaPaint instance
canvas.drawBitmap(originalBitmap, 0, 0, alphaPaint);

// now lets store the bitmap to a file - the canvas has drawn on the newBitmap, so we can just store that one
// please add stream handling with try/catch blocks
FileOutputStream fos = new FileOutputStream(new File("/awesome/path/to/bitmap.png"));
newBitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);