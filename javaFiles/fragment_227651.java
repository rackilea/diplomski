settings.setProcessor(new AbstractRowProcessor() {
    @Override
    public void rowProcessed(String[] row, ParsingContext context) {
        System.out.println(Arrays.toString(row));
        context.skipLines(3); //use the context object to control the parser
    }
});

CsvParser parser = new CsvParser(settings);
//`parse` doesn't return anything. Rows go to the `rowProcessed` method.
parser.parse(new StringReader(input));