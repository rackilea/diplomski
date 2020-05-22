for (int r = 0; r < rowCount; r++) {
    for (int c = 0; c < colCount; c++) {
        cells = row.getCell(c);
        String cellval = cells.toString();
        System.out.print(" | " + cellval);   //New line IS NOT printed
    }
    System.out.println(" |");                //New line IS printed
}