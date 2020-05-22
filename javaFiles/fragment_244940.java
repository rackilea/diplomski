public void exportCsv2(HttpServletResponse response) throws IOException {
    List<Person> list = new ArrayList<>();
    Person person1 = new Person(1, "チャウ　クエ　ギー", 23);
    Person person2 = new Person(2, "グエン　イエン　タイン", 24);
    Person person3 = new Person(3, "ファン　ティ　タイン　トウイ", 25);
    Person person4 = new Person(4, "ホアン ガー れ　テイ　トゥ　ウエン", 26);

    list.add(person1);
    list.add(person2);
    list.add(person3);
    list.add(person4);

    String[] headers = {"ID", "Name", "Age"};
    response.setContentType("application/vnd.ms-excel:UTF-8"); // or you can use text/csv
    response.setHeader("Content-Disposition", "attachment; filename=listPerson.csv");
    OutputStream outputStream= response.getOutputStream();
    outputStream.write(0xEF);
    outputStream.write(0xBB);
    outputStream.write(0xBF);

    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
    CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(headers));
    list.forEach(person -> {
        try {
            csvPrinter.printRecord(person.getId(),person.getName(),person.getAge());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    });
    csvPrinter.close();
}