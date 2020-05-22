private ArrayList<ImageItem> getData() {
    final ArrayList<ImageItem> imageItems = new ArrayList<>();
    TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);
    for (int i = 0; i < imgs.length(); i++) {
        Log.d(TAG, "Image ID: " + String.valueOf(i));
        // no need to load image here
        // Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
        imageItems.add(new ImageItem(i, imgs.getResourceId(i, -1), "Image#" + i));
    }
    return imageItems;
}