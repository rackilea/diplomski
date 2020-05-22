@Override
protected MediaType handleNoMatch(NativeWebRequest webRequest, String extension)
        throws HttpMediaTypeNotAcceptableException {

    if (this.useJaf) {
        MediaType jafMediaType = JafMediaTypeFactory.getMediaType("file." + extension);
        if (jafMediaType != null && !MediaType.APPLICATION_OCTET_STREAM.equals(jafMediaType)) {
            return jafMediaType;
        }
    }
    if (!this.ignoreUnknownExtensions) {
        throw new HttpMediaTypeNotAcceptableException(getAllMediaTypes());
    }
    return null;
}