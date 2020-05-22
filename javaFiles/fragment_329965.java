public class NoopParserNewArray implements Parser {
    @Override public String[] supportedSchemas() {
        return new String[0];
    }

    @Override public void parse(String s) {
        s.codePoints().count();
    }
}