public static void main(final String... args)
        throws IOException {
    try ( final EnhancedGson25JsonReader input = getEnhancedGson25JsonReader(new InputStreamReader(new FileInputStream("./huge.json")));
          final Writer output = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream("./huge.json.STRINGS"))) ) {
        while ( input.hasNext() ) {
            final JsonToken token = input.peek();
            switch ( token ) {
            case BEGIN_OBJECT:
                input.beginObject();
                break;
            case NAME:
                input.nextName();
                break;
            case STRING:
                input.nextSlicedString(output::write);
                break;
            default:
                throw new AssertionError(token);
            }
        }
    }
}