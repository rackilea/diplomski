public String getExtension(BaseDocument document) {
    TikaConfig config = TikaConfig.getDefaultConfig();
    MediaType mediaType = null;
    MimeType mimeType = null;
    try {
        mediaType = config.getMimeRepository().detect(new ByteArrayInputStream(document.getFile()), new Metadata());
        mimeType = config.getMimeRepository().forName(mediaType.toString());
    } catch (MimeTypeException | IOException e) {
        //throw;
    }

    return mimeType.getExtension();
}