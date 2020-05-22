import org.openjdk.jmh.annotations.Benchmark;

public class EmptyArrayBenchmark {
    private static final Parser NOOP_PARSER_STATIC_ARRAY = new NoopParserStaticArray();
    private static final Parser NOOP_PARSER_NEW_ARRAY = new NoopParserNewArray();

    @Benchmark
    public void staticEmptyArray() {
        Parser parser = NOOP_PARSER_STATIC_ARRAY;
        for (String schema : parser.supportedSchemas()) {
            parser.parse(schema);
        }
    }

    @Benchmark
    public void newEmptyArray() {
        Parser parser = NOOP_PARSER_NEW_ARRAY;
        for (String schema : parser.supportedSchemas()) {
            parser.parse(schema);
        }
    }
}