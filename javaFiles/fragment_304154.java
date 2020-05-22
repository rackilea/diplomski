CsvToBean<MyObject> csvToBean = new CsvToBeanBuilder<MyObject>(reader)
                    .withType(MyObject.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSeparator(',')
                    //.withIgnoreQuotations(true)
                    .withSkipLines(1)
                    .build();