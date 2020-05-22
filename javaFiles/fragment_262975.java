Paragraph prefaceX = new Paragraph();
prefaceX.setAlignment(Element.ALIGN_CENTER);
document.add(prefaceX);
document.add(Chunk.NEWLINE);
document.add(new Paragraph(getString(R.string.report_title), catFont));
document.add(new Paragraph(getString(R.string.disclaimer), smallBoldMM));