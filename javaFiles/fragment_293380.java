try (InputStream inputStream = multipartFile.getInputStream())
    {
        Workbook wb = WorkbookFactory.create(inputStream);
        // opening the first sheet
        Sheet sheet = wb.getSheetAt(0); 
        // read the third row
        Row row = sheet.getRow(2);
        // read 4th cell
        Cell cell = row.getCell(3);
        // get the string value
        String myValue = cell.getStringCellValue();

        // store in the database...         
    } catch (IOException e) {
        //TODO
    }