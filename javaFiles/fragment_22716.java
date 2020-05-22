for (int i=0; i<10; i++) {
        Row row = sheetOLD.createRow(i);
        Cell cell = row.createCell(0);
        cell.setCellValue(i);
}

for (int i=0; i<3; i++){
    @SuppressWarnings("resource")
    Scanner input = new Scanner(System.in);
    Cell name = sheetOLD.getRow(i).createCell(1);
    name.setCellValue(input.nextLine());
    }

Cell test = sheetOLD.getRow(7).createCell(1);
    test.setCellValue("TEST");