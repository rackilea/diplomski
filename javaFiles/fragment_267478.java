//keys are possible headers, and values are the indexes where each header will be mapped to:
Map<String, Integer> headerPositions = new LinkedHashMap<String, Integer>();
headerPositions.put("UniqueCode", 0);
headerPositions.put("Name", 1);
headerPositions.put("dogId", 2);
headerPositions.put("catId", 2);
headerPositions.put("cowId", 2);

CsvParserSettings settings = new CsvParserSettings();
//we want headers
settings.setHeaderExtractionEnabled(true);

//let's use the custom row processor:
MyBeanProcessor<MyPOJO> processor = new MyBeanProcessor<MyPOJO>(MyPOJO.class, headerPositions);
settings.setRowProcessor(processor);

CsvParser parser = new CsvParser(settings);
parser.parse(<YOUR_INPUT_HERE>);

List<MyPOJO> myPojos = processor.getBeans();