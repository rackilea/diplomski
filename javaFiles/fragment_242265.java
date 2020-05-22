public void getGalleryImage() {
    final Intent galleryIntent = Intent(Intent.ACTION_GET_CONTENT);
    galleryIntent.addCategory(Intent.CATEGORY_OPENABLE);
    galleryIntent.setType("image/*");
    startActivityForResult(galleryIntent, 1);
}