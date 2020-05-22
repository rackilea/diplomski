public static <T> List<T> parseCSVWithHeader(Class<T> cls, String fileName) 
                throws IOException {
    try (CSVReader reader = new CSVReader(new FileReader(fileName), ',')) {
        HeaderColumnNameMappingStrategy<T> beanStrategy = new HeaderColumnNameMappingStrategy<>();
        beanStrategy.setType(cls);

        CsvToBean<T> csvToBean = new CsvToBean<>();
        List<T> emps = csvToBean.parse(beanStrategy, reader);
        System.out.println(emps);
        return emps;
    }
}