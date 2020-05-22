BufferedImage image = null;
InputStream stream = null;
try {
    stream = new FileInputStream(file);
    image = ImageIO.read(stream);

} catch (Exception ex) {
    log.error("Image could not be read: "+file);

} finally {
    if (stream != null) {
        try {
            stream.close();
        } catch (IOException ex) {
            log.error("ERROR closing image input stream: "+ex.getMessage(), ex);
        }
    }
}