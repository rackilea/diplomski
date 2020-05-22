public static void main(String... args) {
    Person person = new Person();
    person.uid = "XYZ";
    person.nsUniqueID = "abc";
    person.isMemberOf.add("group1");
    person.isMemberOf.add("group2");
    person.isMemberOf.add("group3");

    StringWriter out = new StringWriter();

    CsvWriterSettings settings = new CsvWriterSettings();
    settings.setHeaderWritingEnabled(true);
    settings.setRowWriterProcessor(new BeanWriterProcessor<Person>(Person.class));

    CsvWriter writer = new CsvWriter(out, settings);

    while (person.hasMoreGroups()) {
        writer.processRecord(person);
    }
    writer.close();

    System.out.println(out.toString());
}