public static void main(String... args){
    String input = "" +
            "20, \"bob, XXX\", \"test\", 30\n" +
            "20, \"evan\"s,YYY \", \"test\", 30\n" +
            "20, \"Tom, ZZZ\", \"test\", 30 ";


    CsvParserSettings settings = new CsvParserSettings();

    CsvParser parser = new CsvParser(settings);
    List<String[]> rows = parser.parseAll(new StringReader(input));

    //printing values enclosed in [ ]  to make sure you are getting the expected result
    for(String[] row : rows){
        for(String value : row){
            System.out.print("[" + value + "],");

        }
        System.out.println();
    }
}