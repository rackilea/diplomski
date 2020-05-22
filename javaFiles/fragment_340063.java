@RequestMapping(value="/image", method=RequestMethod.PUT, consumes="multipart/form-data") 
public @ResponseBody void addImage(HttpServletRequest request) throws ImageException {
    byte[] bytes = getBytesFromFile(request);
    Image image = new Image();
    image.setByteData(bytes);
    imageService.addImage(image);
}

private byte[] getBytesFromFile(HttpServletRequest request) throws ImageException {
    ServletFileUpload upload = new ServletFileUpload();
    byte[] bytes = null;
    FileItemIterator iter;
    try {
        iter = upload.getItemIterator(request);
        while(iter.hasNext()) {
            FileItemStream item = iter.next();
            InputStream stream = item.openStream();
            bytes = IOUtils.toByteArray(stream);
        }
        return bytes;
    } catch (IOException | FileUploadException e) {
        throw new ImageException("The problem while storing file. Try again.",e);
    }
}