float x = touchEvent.getX();
float y = touchEvent.gety();
// Replace these with the correct values (bitmap x, y, width & height)
float x1 = bitmapPositionX;
float x2 = x1 + bitmapWidth;
float y1 = bitmapPositionY;
float y2 = y1 + bitmapHeight;
// Test to see if touch is inside the bitmap
if (x > x1 && x < x2 && y > y1 && y < y2) {
    // Bitmap was touched
    switch (touchEvent.getAction()) {
    case TouchEvent.ACTION_DOWN: (bitmap was just touched) break;
    case TouchEvent.ACTION_DOWN: (user lifted finger from bitmap) break;
    }
}