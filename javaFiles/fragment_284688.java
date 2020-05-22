CSVReader csvReader = new CSVReader(new FileReader("Simple.csv"));
        Class aClass = Class.forName("com.ishikawa.csvparser.entity.SimpleEntity");
        CsvToBean ctb = new CsvToBean();
        HashMap<String, String> columnMapping = new HashMap<>();

        HeaderColumnNameTranslateMappingStrategy headerStrategy = new HeaderColumnNameTranslateMappingStrategy();

        columnMapping.put("LANGU", "name");
        headerStrategy.setType(aClass);
        headerStrategy.setColumnMapping(columnMapping);

        ctb.setMappingStrategy(headerStrategy);
        ctb.setCsvReader(csvReader);



        List parse = ctb.parse();
        parse.stream().forEach(e->{
            if (e instanceof SimpleEntity) {
                System.out.println(((SimpleEntity)e).getName());
            }
        });