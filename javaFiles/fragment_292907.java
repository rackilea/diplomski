public <T extends AbstractObj> List<T> csvObjConverter(Reader r, Class<T> clazz) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
    CsvParserSettings parserSettings = new CsvParserSettings();
    parserSettings.getFormat().setLineSeparator("\n");
    parserSettings.setHeaderExtractionEnabled(true);
    parserSettings.detectFormatAutomatically();
    parserSettings.setMaxCharsPerColumn(90000);
    CsvParser parser = new CsvParser(parserSettings);
    parser.beginParsing(r);
    String[] row;
    ArrayList<T> objects = new ArrayList<>();
    Constructor<T> cons = clazz.getConstructor (String[].class);
    while ((row = parser.parseNext()) != null) {
        T obj = cons.newInstance((Object) row);    
        objects.add(obj);
    }
    parser.stopParsing();
    return objects;
}