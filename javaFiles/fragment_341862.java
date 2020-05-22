@Override
    public void onEndPage(PdfWriter writer, Document document) {
        if (isLetter) {
            //That's only for the first page, apparently 1 is too late
            //I'm open for improvements but that works fine for me
            if (writer.getPageNumber() == 0) {

            //If it's a letter we use the different margins
            document.setMargins(36, 36, 100, 36);
            }
            if (writer.getPageNumber() == 1) {
            PdfContentByte canvas = writer.getDirectContent();

            float llx = 460;
            float lly = 742;

            float urx = 36;
            float ury = 607;

            //As I add the rectangle in the event here it's 
            //drawn over the table-header. Seems the tableheader
            //is rendered afterwards
            Rectangle rect1 = new Rectangle(llx, lly, urx, ury);
            rect1.setBackgroundColor(BaseColor.WHITE);
            rect1.setBorder(Rectangle.NO_BORDER);
            rect1.setBorderWidth(1);
            canvas.rectangle(rect1);

            ColumnText ct = new ColumnText(canvas);
            ct.setSimpleColumn(rect1);
            PdfPTable minitable = new PdfPTable(1);
            PdfPCell cell = PDFKopf.getKundenCol(PDFHeader.getCustomer(customerNumber));
            cell.setBorder(Rectangle.NO_BORDER);
            minitable.addCell(cell);

            //A single cell is not accepted as an "Element"
            //But a table including only a single cell is
            ct.addElement(minitable);
            try {
                ct.go();
            } catch (DocumentException ex) {
                Logger.getLogger(HeaderFooter.class.getName()).log(Level.SEVERE, null, ex);
            }

        //In any other case we reset the margins back to normal
        //This could be solved in a more intelligent way, feel free
        } else {
            document.setMargins(36, 36, 36, 36);
        }
    }

    //The regular header of any page...
    PdfPTable table = new PdfPTable(4);

    try {
        table.setWidths(new int[]{16, 16, 16, 2});
        table.setWidthPercentage(100);

        table.setTotalWidth(527);
        table.setLockedWidth(true);

        table.getDefaultCell().setFixedHeight(20);
        table.getDefaultCell().setBorder(Rectangle.BOTTOM);
        table.addCell(header);
        PdfPCell cell;

        cell = new PdfPCell(new Phrase(mittelteil));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(Rectangle.BOTTOM);
        table.addCell(cell);

        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.addCell(String.format("Page %d of ", writer.getPageNumber()));
        cell = new PdfPCell(Image.getInstance(total));
        cell.setBorder(Rectangle.BOTTOM);
        table.addCell(cell);
        table.writeSelectedRows(0, -1, 34, y, writer.getDirectContent());
    } catch (DocumentException de) {
        throw new ExceptionConverter(de);
    }
}