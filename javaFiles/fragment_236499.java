public int getSize(Attachment document){
    byte[] documentInByte;
    try {
        documentInByte = 
        IOUtils.toByteArray(document.getDataHandler().getInputStream());
    } catch (IOException e) {
        throw new UncheckedIOException(e);
    }

    return data.length;
}