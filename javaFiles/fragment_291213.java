@Test
public void testForAlphaOmega() throws IOException {
    @Getter
    class ROOM {
        String id;
        String name;
        String phoneNumber;
        String pin;

        private ROOM(String id, String name, String phoneNumber, String pin){
            this.id = id;
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.pin = pin;
        }
        private ROOM(CSVRecord record){
            this.id = record.get("ID");
            this.name = record.get("name");
            this.phoneNumber = record.get("phoneNumber");
            this.pin = record.get("PIN");
        }
    }
    try (
        Reader reader = Files.newBufferedReader(Paths.get("....PATH_OF_FILE"));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
        .withHeader("ID", "name", "phoneNumber", "PIN")
        .withIgnoreHeaderCase()
        .withFirstRecordAsHeader()
        .withDelimiter(';')
        .withTrim())
    ) {
        List<ROOM> rooms = new ArrayList<>();
        csvParser.getRecords().stream().map(ROOM::new).collect(groupingBy(ROOM::getName)).forEach((key,val) -> rooms.add(new ROOM(val.get(0).getId(), val.get(0).getName(), val.stream().map(ROOM::getPhoneNumber).collect(Collectors.joining(",")),val.get(0).getPin())));
        rooms.forEach(item -> System.out.println(item.getId() + ";" + item.getName() +";" + item.getPhoneNumber() + ";" + item.getPin()));
    }
}