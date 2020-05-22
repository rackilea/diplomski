if (part.getContent() instanceof BASE64DecoderStream)
{
    BASE64DecoderStream base64DecoderStream = (BASE64DecoderStream) part.getContent();
    byte[] byteArray = IOUtils.toByteArray(base64DecoderStream);
    byte[] encodeBase64 = Base64.encodeBase64(byteArray);
    base64Content[0] = new String(encodeBase64, "UTF-8");
    base64Content[1] = getContentTypeString(part);
}