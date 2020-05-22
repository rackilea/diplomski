for (int i=0; i<row.getLastCellNum(); i++) {
        Cell cell = row.getCell(i, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
        if (cell == null) {
            // ...
        } else {
            // ...
        }
    }