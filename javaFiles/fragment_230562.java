class Base64ImageProvider extends AbstractImageProvider {

    @Override
    public Image retrieve(String src) {
        int pos = src.indexOf("base64,");
        try {
            if (src.startsWith("data") && pos > 0) {
                byte[] img = Base64.decode(src.substring(pos + 7));
                return Image.getInstance(img);
            }
            else {
                return Image.getInstance(src);
            }
        } catch (BadElementException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }

    @Override
    public String getImageRootPath() {
        return null;
    }
}