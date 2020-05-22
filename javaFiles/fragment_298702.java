List<ThingOne> l1 = parse(ThingOne.class, "file1");
List<ThingTwo> l2 = parse(ThingTwo.class, "file2");

public static <T> List<T> parse(Class<T> clazz, String fName) throws FileNotFoundException{
    BeanListProcessor<T> rowProcessor = new BeanListProcessor<>(clazz);
    TsvParserSettings tsvSet = new TsvParserSettings();
    tsvSet.setHeaderExtractionEnabled(true);
    tsvSet.setProcessor(rowProcessor);
    TsvParser p = new TsvParser(tsvSet);
    FileReader f = new FileReader(fName);
    p.parse(f);        
    return rowProcessor.getBeans();
}