XSSFCellStyle cellStyle = wb.createCellStyle();

        XSSFColor color = new XSSFColor(new java.awt.Color(value, 0, 0));

        ((XSSFCellStyle)cellStyle).setFillBackgroundColor(color);
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setFillForegroundColor(color); 
        cell.setCellStyle(cellStyle);