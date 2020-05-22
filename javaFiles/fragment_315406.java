switch(cell.getCellType()) {
                case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING:
                    data = cell.getRichStringCellValue().toString();
                    break;
                case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC:
                    data = Integer.toString((int)cell.getNumericCellValue());
                    break;
            }