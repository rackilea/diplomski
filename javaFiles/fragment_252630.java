@Get
public String getImage() {
    [...]
    byte[] data = readImage();
    return new StringRepresentation(
        Base64.encode(data, false),
        MediaType.TEXT_PLAIN);
}