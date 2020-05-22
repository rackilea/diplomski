public Bitmap getBitMap() {
    try {
        yourEditedPhotoCollageLayout.buildDrawingCache();
        Bitmap bmp = Bitmap.createBitmap(yourEditedPhotoCollageLayout.getDrawingCache());
        return bmp;
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}