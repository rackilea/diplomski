DataFormatter fmt = new DataFormatter();
 for (Row r : sheet) {
    for (Cell c : r) {
       CellReference cr = new CellRefence(c);
       System.out.println("Cell " + cr.formatAsString() + " is " + 
                          fmt.formatCellValue(c) );
    }
 }