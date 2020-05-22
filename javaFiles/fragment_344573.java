final CellStyle cellStyle = wb.createCellStyle();
        //cellStyle.setFillPattern(FillPatternType.ALT_BARS);

        XSSFCellFill fill = new XSSFCellFill(CTFill.Factory.newInstance());
        final CTGradientFill ctGradientFill = fill.getCTFill().addNewGradientFill();
        ctGradientFill.setDegree(45);
        // ...
        ((XSSFWorkbook)wb).getStylesSource().putFill(fill);

        cell.setCellStyle(cellStyle);