CSVFormat format = CSVFormat.DEFAULT
                .withRecordSeparator(',')
                .withIgnoreEmptyLines()
                .withQuote('"');
        CSVParser parser = CSVParser.parse(new File("/file/path/csv"), Charset.defaultCharset(), format);
        List<CSVRecord> recordList = parser.getRecords();
        for (CSVRecord record : recordList) {
            Iterator<String> it = record.iterator();
            while (it.hasNext()) {
                System.out.print(it.next().replace("\n", "") + "|");
            }
            System.out.println();
        }