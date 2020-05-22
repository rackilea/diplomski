private static final String _name = "Name:";
private static final String _dateOfBirth = "Date Of Birth:";
private static final String _major = "Major:";

PdfPTable table = new PdfPTable(2);

PdfPCell spaceCell = new PdfPCell(new Phrase("  ", normalFont));
PdfPCell nameCell = new PdfPCell(new Phrase(_name, normalFont));
PdfPCell dateOfBirthCell = new PdfPCell(new Phrase(_dateOfBirth, normalFont));
PdfPcell majorCell = new PdfPCell(new Phrase(_major, normalFont));

table.addCell(nameCell);
table.addCell(spaceCell);
table.addCell(dateOfBirthCell);
table.addCell(spaceCell);
table.addCell(spaceCell); // if you want an extra line break here a fill a line
table.addCell(spaceCell); // with space cells
table.addCell(majorCell);

overviewCell.addElement(table);