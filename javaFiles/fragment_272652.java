final int w = 700;
final int h = 700;
final int n = w * h;
final int [] buf = new int[n];
for (int y = 0; y < h; y++) {
    final int yw = y * w;
    for (int x = 0; x < w; x++) {
        int i = yw + x;
        // Calculate 'pixelARGB' here.
        buf[i] = pixelARGB;
    }
}
Bitmap result = Bitmap.createBitmap(buf, w, h, Bitmap.Config.ARGB_8888);