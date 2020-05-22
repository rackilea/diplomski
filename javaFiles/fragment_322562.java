if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
    if (cell.getCellStyle().getDataFormatString().contains("%")) {
        // Detect Percent Values 
        Double value = cell.getNumericCellValue() * 100;
        System.out.println("Percent value = " + value.toString() +"%");
    } else {
        Double value = cell.getNumericCellValue();
        System.out.println("Non percent value = " + value.toString());
    }
}