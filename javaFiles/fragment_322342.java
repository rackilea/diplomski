if (canvas == null) {
    Log.i("canvas", "canvas is null");
}

if (bitmap == null) {
    Log.i("bitmap", "bitmap is null");
}

canvas.drawBitmap(bitmap, null, dstRect, paint);