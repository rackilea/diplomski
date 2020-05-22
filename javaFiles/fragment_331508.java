private File createImageFile() throws IOException {
    // Create an image file name
    String imageFileName = "registroFoto";
    File directory = new File(getFilesDir(), "app_imageDir");

    directory.mkdirs();

    return File.createTempFile(
            imageFileName,  /* prefix */
            ".jpg",         /* suffix */
            directory
    );
}