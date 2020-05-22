public static DataExtractor create(String dataspec) {
    CharStream stream = new ANTLRInputStream(dataspec);
    DataSpecificationLexer lexer = new DataSpecificationLexer(stream);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    DataSpecificationParser parser = new DataSpecificationParser(tokens);

    return parser.dataspec().extractor;
}