Range range = sheet.getCells().createRange(startRow, startColumn, endRow - startRow + 1, endColumn - startColumn + 1);

        Style style = workbook.createStyle();
        style.setHorizontalAlignment(TextAlignmentType.LEFT);

        StyleFlag flg = new StyleFlag();
        flg.setHorizontalAlignment(true);

        range.applyStyle(style, flg);