public void renderImage(ImageRenderInfo renderInfo) {
    try {
        String filename;
        FileOutputStream os;
        PdfImageObject image = renderInfo.getImage();
        if (image == null) return;
        filename = String.format(path,
            renderInfo.getRef().getNumber(), image.getFileType());
        os = new FileOutputStream(filename);
        os.write(image.getImageAsBytes());
        os.flush();
        os.close();
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
}