WritableHyperlink hl = new WritableHyperlink(0, 0, 
            new URL("http://www.google.com"));
    sheet.addHyperlink(hl);

    WritableFont redFont = new WritableFont(WritableFont.ARIAL);
    redFont.setColour(Colour.RED);
    WritableCellFormat cellFormat = new WritableCellFormat(redFont);
    Label label = new Label(0, 0, "home page", cellFormat);
    sheet.addCell(label);