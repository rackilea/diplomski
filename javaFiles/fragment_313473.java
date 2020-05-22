if (/* 5 elements */) {
    // add your table to the document
    document.add(itemListTab);

    // create a new page
    document.newPage();

    // create a new table
    itemListTab = new PdfPTable(colsWidth);
}