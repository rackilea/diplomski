RtfHeaderFooter footer = new RtfHeaderFooter();
Paragraph p = footer.paragraph();
p.add(new RtfPageNumber());
p.add( " of ");
p.add(new RtfTotalPageNumber());

myRtfWriter2.setFooter(footer);