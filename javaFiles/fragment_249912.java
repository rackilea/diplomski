XSLFTableRow headerRow = table.addRow();
    for(int i = 0; i < 3; i++) {
        XSLFTableCell th = headerRow.addCell();
        XSLFTextParagraph p = th.addNewTextParagraph();
        XSLFTextRun r = p.addNewTextRun();
        r.setText("Text");
    }