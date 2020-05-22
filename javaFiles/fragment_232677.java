String infile = "D:\\libro.pdf";
String outfile = "D:\\test_out.pdf";
PdfDocument pdfDoc = new PdfDocument(new  PdfWriter(outfile).setSmartMode(true));
pdfDoc.setDefaultPageSize(PageSize.A2.rotate());
PdfPage pageorig, pagenew;
PdfCanvas canvas;
PdfDocument reader = new PdfDocument(new PdfReader(infile));

// Caching page copies
Map<Integer, PdfFormXObject> pageCopies = new HashMap<>();

int pages = reader.getNumberOfPages();
for (int j = 0; j < 10; j++) {
    for (int i = 1; i <= pages; i++) {
        pageorig = reader.getPage(i);
        PdfFormXObject origPageCopy = pageCopies.get(i);
        // Cache miss, doing a fresh copy
        if (origPageCopy == null) {
            origPageCopy = pageorig.copyAsFormXObject(pdfDoc);
            pageCopies.put(i, origPageCopy);
        }

        pagenew = pdfDoc.addNewPage();
        canvas = new PdfCanvas(pagenew);

        canvas.addXObject(origPageCopy, 0, 0);
        canvas.addXObject(origPageCopy, pageorig.getPageSize().getWidth(), 0);
    }
}
pdfDoc.close();
reader.close();