/**
 * Borrowed from the MongoDB toJSON method for Documents, except we dont
 * instantiate the JSON String but return an InputStream instead.
 *
 * @return a buffer containing the JSON representation of the given document
 * @throws org.bson.codecs.configuration.CodecConfigurationException if the
 *         registry does not contain a codec for the document values.
 */
private InputStream toJson(Document document) {
    JsonWriter writer = new JsonWriter(new StringWriter(), new JsonWriterSettings(true));

    new DocumentCodec().encode(writer, document,
            EncoderContext.builder().isEncodingCollectibleDocument(true).build());

    CharSequence result = ((StringWriter) writer.getWriter()).getBuffer();

    return new CharSequenceInputStream(result, Charset.forName("UTF-8"));
}