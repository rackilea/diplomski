public class NoopParserStaticArray implements Parser {
    private static final String[] EMPTY_STRING_ARRAY = new String[0];

    @Override public String[] supportedSchemas() {
        return EMPTY_STRING_ARRAY;
    }

    @Override public void parse(String s) {
        s.codePoints().count();
    }
}