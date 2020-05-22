switch(cell.getCellType()) {
    case Cell.CELL_TYPE_STRING:
        System.out.print(cell.getStringCellValue() + "\t\t");
        break;
    case Cell.CELL_TYPE_NUMERIC:
        if (DateUtil.isCellDateFormatted(cell)) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            System.out.print(dateFormat.format(cell.getDateCellValue()) + "\t\t");
        } else {
            System.out.print(cell.getNumericCellValue() + "\t\t");
        }
        break;
    case Cell.CELL_TYPE_BOOLEAN:
        System.out.print(cell.getBooleanCellValue() + "\t\t");
        break;
}