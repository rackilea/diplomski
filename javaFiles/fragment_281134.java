public class Foo {
   ...
   @JsonDeserialize(using = UrlDeseralizer.class)
   private URL url;
   ...
}

public class UrlDeseralizer extends JsonDeserializer<URL> {

    private Pattern urlPrefix = Pattern.compile("^(https?://|ftp://).*");

    @Override
    public URL deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = p.getCodec();
        JsonNode node = objectCodec.readTree(p);
        String stringUrl = node.asText();
        if (!urlPrefix.matcher(stringUrl).matches()) {
            return new URL("http://" + stringUrl);
        } else {
            return new URL(stringUrl);
        }
    }

}