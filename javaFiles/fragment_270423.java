InputStream is = GLRenderer.context.getResources().openRawResource(textureId);
Bitmap bitmap;
try {
    bitmap = BitmapFactory.decodeStream(is);
} finally {
    try {
        is.close();
    } catch(IOException e) {
        // Ignore.
    }
}