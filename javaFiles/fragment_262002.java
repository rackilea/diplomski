public void createCsv() throws Exception {

    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    CsvWriter writer = new CsvWriter(stream, ',', Charset
            .forName("ISO-8859-1"));

    writer.setRecordDelimiter(';');
    // WRITE Your CSV Here
    //writer.write("a;b");
    writer.endRecord();
    writer.close();

    stream.close();    }