private static List<TableRow> parseExcelColumnData(List<?> sheetData) {
        // read each row from 1 to the last
        ArrayList<TableRow> tousRows = new ArrayList<TableRow>();
        for (int rowCounter = 1; rowCounter < sheetData.size(); rowCounter++) {

            List<?> list = (List<?>) sheetData.get(rowCounter);

            LinkedHashMap<String, List<Integer>> tableFields = new LinkedHashMap<String, List<Integer>>(list.size());
            String str;
            String[] tousFields = new String[list.size()];

            int i = 0;
            Cell cell = (Cell) list.get(0);
            long currentID = (long) cell.getNumericCellValue();
            for (int j = 0; j < list.size(); j++) {
                cell = (Cell) list.get(j); 
                if (cell != null) {
                    if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                        put(tableFields, String.valueOf(cell.getNumericCellValue()), cell);
                    } else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                        put(tableFields, cell.getStringCellValue(), cell);
                    } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
                        put(tableFields, String.valueOf(cell.getBooleanCellValue()), cell);
                    } else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                        put(tableFields, cell.getStringCellValue(), cell);
                    }
                }
            }
            tousRows.add(new TableRow(currentID, tableFields));
        }

        return tousRows;

    }

    private static void put(LinkedHashMap<String, List<Integer>> tableFields, String cellValue, Cell cell) {
        if (!tableFields.containsKey(cellValue)) {
            tableFields.put(cellValue, new ArrayList<Integer>());
        }

        tableFields.get(cellValue).add(cell.getCellType());
    }