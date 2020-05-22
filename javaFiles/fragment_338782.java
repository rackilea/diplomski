BitmapField imageCanvas = new BitmapField();

    InputStream input = photoFile.openInputStream();

    int fileSize = (int) photoFile.fileSize();
    byte[] data = new byte[fileSize];
    input.read(data, 0, fileSize);

    Bitmap photoBitmap = EncodedImage.createEncodedImage(data, 0, data.length).getBitmap();
    imageCanvas.setBitmap(photoBitmap);
    add(imageCanvas);