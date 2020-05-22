try (CSVReader reader = new CSVReader(sr, ';')) {
    String[] nextCsvLine;
    while ((nextCsvLine = reader.readNext()) != null) {
        int count = 0;
        for (String field: nextCsvLine) {
            log.debug("Line read : "+linewithsemicolon);
            if (count == 6) { // 7th column
                detailItems.add(field);
                log.debug("7th position: " + field);
            }                   
            count++;
        }
    }