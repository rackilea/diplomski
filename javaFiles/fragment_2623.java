PdfContentByte cb = writer.getDirectContent();
ColumnText[] columns = new ColumnText[3];
for (int section = 1; section <= 3; section++) {
    for (int la = 0; la < 3; la++) {
        columns[la] = createColumn(cb, section, LANGUAGES[la], RECTANGLES[la]);
    }
    while (addColumns(columns)) {
        document.newPage();
        for (int la = 0; la < 3; la++) {
            columns[la].setSimpleColumn(RECTANGLES[la]);
        }
    }
    document.newPage();
}