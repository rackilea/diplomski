final ColumnPositionMappingStrategy<JavaBeanExample> strategy = new ColumnPositionMappingStrategy<>();
strategy.setType(JavaBeanExample.class);
strategy.setColumnMapping(new String[]{"name", "orderNumber", "id"});
final CsvToBean<JavaBeanExample> csvToBean = new CsvToBean<>();
final List<JavaBeanExample> beanExamples;
try (final Reader reader = new FileReader("myFile.csv")) {
    beanExamples = csvToBean.parse(strategy, reader);
} catch (IOException ex) {
    throw new RuntimeException(ex);
}