int width, height; // from header
int dataOffset; // == end of header

// Create pixel array, and expand 8 bit gray to ARGB_8888
int[] pixels = new int[width  * height];
for (int y = 0; y < height; y++) {
    for (int x = 0; x < width; x++) {
         int gray = decodedString[dataOffset + i] & 0xff;
         pixels[i] = 0xff000000 | gray << 16 | gray << 8 | gray;
    }
}

Bitmap pgm = Bitmap.createBitmap(metrics, pixels, width, height, BitmapConfig.Config. ARGB_8888);