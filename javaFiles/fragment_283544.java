// process all pictures in document
for (XWPFPictureData picture : datax.getAllPictures()) {
    // get each picture as byte array
    byte[] pictureData = picture.getData();
    // process picture somehow
    ...
}