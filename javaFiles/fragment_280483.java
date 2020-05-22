Document doc = new Document(PageSize.A4, 0f, 0f, 0f, 0f);
float fntSize, lineSpacing;
fntSize = 6.7f;
lineSpacing = 10f;
Paragraph p = new Paragraph(new Phrase(lineSpacing,line,
               FontFactory.getFont(FontFactory.COURIER, fntSize)));
doc.add(p);