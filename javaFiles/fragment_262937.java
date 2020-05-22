public class ExportTicket implements Action{

    // Fonts
    Font headingFont = new Font(Font.FontFamily.UNDEFINED, 10, Font.BOLD, BaseColor.BLACK);

    public String performAction(HttpServletRequest request) throws PewException {
        String ticketNo = request.getParameter("ticketNo");
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("Ticket_" + ticketNo + ".pdf"));
        // Open Document to Write
        document.open();

        // Table Creation
        PdfPTable table = new PdfPTable(2);
        table.setTotalWidth(200);
        table.setWidths(new int[]{ 5, 10 });
        table.setHorizontalAlignment(Element.ALIGN_LEFT);

        // Add Ticket Number
        PdfPCell contentCell = new PdfPCell()
        contentCell.addElement(new Chunk("Ticket Number: " + ticketNo, headingFont));
        contentCell.setColspan(2);
        table.addCell(contentCell);

        // Add table to Document & Close Document
        document.add(table)
        document.close();
    }
}