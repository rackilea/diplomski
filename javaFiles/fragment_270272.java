Document document = new Document();
PdfWriter.getInstance(document, new FileOutputStream(dest));
document.open();
DottedLineSeparator separator = new DottedLineSeparator();
Chunk c = new Chunk(separator);
Paragraph p = new Paragraph("Ends with dots ");
p.add(c);
document.add(p);
p = new Paragraph("This is a much longer paragraph that spans "
    + "several lines. The String used to create this paragraph "
    + "will be split automatically at the end of the line. The "
    + "final line of this paragraph will end in a dotted line. ");
p.add(c);
document.add(p);
document.close();