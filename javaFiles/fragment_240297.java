while (imageIter.hasNext()) {
    String key = (String) imageIter.next();
    PDXObjectImage image = (PDXObjectImage) images.get(key);

    FileOutputStream output = new FileOutputStream(new File(
            "C:\\Users\\Anton\\Documents\\lol\\test.jpg"));
    image.write2OutputStream(output);
}