int w = WIDTH_PX, h = HEIGHT_PX;

BitmapConfig conf = Bitmap.Config.ARGB_8888; // see other conf types
Bitmap bmp = Bitmap.createBitmap(w, h, conf); // this creates a MUTABLE bitmap
Canvas canvas = new Canvas(bmp);

// ready to draw on that bitmap through that canvas