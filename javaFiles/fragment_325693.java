CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true).build();
    CsvMapper csvMapper = new CsvMapper();

    vertx.fileSystem().rxReadFile("/home/lbulic/file.csv")
            .map(buffer -> buffer.toString("UTF-8"))
            .map(input -> csvMapper.readerFor(Map.class).with(csvSchema).readValues(input).readAll())
            .map(list -> list.stream().map(Json::encode).collect(Collectors.toList()))
            .subscribe(users -> {
                users.forEach(System.out::println);
            }, err -> System.out.println("Cannot read the file: " + err.getMessage()));