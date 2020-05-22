while (imageIter.hasNext()) {
    String key = (String) imageIter.next();
    PDXObjectImage image = (PDXObjectImage) images.get(key);

    FileOutputStream output = new FileOutputStream(new File(
            "C:\\Users\\Anton\\Documents\\lol\\test.jpg"));
    InputStream is = image.getPDStream().getPartiallyFilteredStream(DCT_FILTERS);
    byte[] buffer = new byte[1024];
    while (is.read(buffer) > 0) {
        output.write(buffer);
    }
}