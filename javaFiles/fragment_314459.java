Bitmap bitmap = ... //Assuming you have a bitmap somehow
for (int x = 0; x < bitmap.getWidth(); x++) {
    for (int y = 0; y < bitmap.getHeight(); y++) {
        bitmap.setPixel(x, y, bitmap.getPixel(x, y) & 0xFFFF0000);
    }
}