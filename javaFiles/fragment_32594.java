parser.beginParsing(new File("/path/to/your.csv"));

String[] row;
while ((row = parser.parseNext()) != null) {
    // process row
}