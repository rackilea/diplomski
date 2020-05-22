XSSFSheet sheet2 = workBook.createSheet("data2");
    List<HashMap<String, Object>> rows = ((List<HashMap<String, Object>>) x);

    List<String> headers = Arrays.asList("kol1", "kol2", "kol3");
    int currentRowNumber = 0;

    // create header row
    Row header = sheet2.createRow(currentRowNumber);
    for (int i = 0; i < headers.size(); i++) {
        Cell headerCell = header.createCell(i);
        headerCell.setCellValue(headers.get(i));
    }

    // create data rows (we loop over the rows List)
    for (int i = 0; i < rows.size(); i++) {
        HashMap<String, Object> row = rows.get(i);

        // we neet to increment the rowNumber for the row in the sheet at the beginning of 
        // each row. entry 0 in the rows List is in sheetRow 1, entry 1 in sheetRow 2, etc.
        currentRowNumber++;
        Row sheetRow = sheet2.createRow(currentRowNumber);

        // we can now loop over the columns inside the row loop (using the headers List)
        // we create a Cell for each column, but only fill it if there is
        for (int j = 0; j < headers.size(); j++) {
            Cell cell = sheetRow.createCell(j);

            // only fill the cell if we are having data in the row map for the current column
            String currentColumnName = headers.get(j);
            if (row.containsKey(currentColumnName)) {
                cell.setCellValue(row.get(currentColumnName).toString());
            }
        }
    }