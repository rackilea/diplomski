public Response upload(final MultipartFormDataInput input)throws Exception{
    Map<String, List<InputPart>> formDataMap = input.getFormDataMap();
    File inputStream = formDataMap.get("files").get(0).getBody(File.class, null);
    String extraField = formDataMap.get("extraField").get(0).getBodyAsString();
    String CustomField =  formDataMap.get("CustomField").get(0).getBodyAsString();

    try {

        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet datatypeSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = datatypeSheet.iterator();

        while (iterator.hasNext()) {

            Row currentRow = iterator.next();
            Iterator<Cell> cellIterator = currentRow.iterator();

            while (cellIterator.hasNext()) {
                Cell currentCell = cellIterator.next();

                if (currentCell.getCellType() == Cell.CELL_TYPE_STRING) {
                    System.out.print(currentCell.getStringCellValue() + "--");
                } else if (currentCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                    System.out.print(currentCell.getNumericCellValue() + "--");
                } else if(currentCell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
                    System.out.print(currentCell.getBooleanCellValue() + "--");
                } else {
                    System.out.print("<BLANK>--");
                }
            }
            System.out.println();

        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }


    input.close();
    return Response.ok("OK").build();
}