PDRectangle rec = new PDRectangle(220, 120);
PDDocument document = null;
document = new PDDocument();

PDPage page = new PDPage(rec);
document.addPage(page);

PDPageContentStream content = new PDPageContentStream(document, page, true, true);

content.beginText();
content.moveTextPositionByAmount(7, 105);
content.setFont(PDType1Font.HELVETICA, 12);
content.drawString("Normal text and ");
content.setFont(PDType1Font.HELVETICA_BOLD, 12);
content.drawString("bold text");
content.moveTextPositionByAmount(0, -25);
content.setFont(PDType1Font.HELVETICA_OBLIQUE, 12);
content.drawString("Italic text and ");
content.setFont(PDType1Font.HELVETICA_BOLD_OBLIQUE, 12);
content.drawString("bold italic text");
content.endText();

content.setLineWidth(.5f);

content.beginText();
content.moveTextPositionByAmount(7, 55);
content.setFont(PDType1Font.HELVETICA, 12);
content.drawString("Normal text and ");
content.appendRawCommands("2 Tr\n");
content.drawString("artificially bold text");
content.appendRawCommands("0 Tr\n");
content.moveTextPositionByAmount(0, -25);
content.appendRawCommands("1 Tr\n");
content.drawString("Artificially outlined text");
content.appendRawCommands("0 Tr\n");
content.setTextMatrix(1, 0, .2f, 1, 7, 5);
content.drawString("Artificially italic text and ");
content.appendRawCommands("2 Tr\n");
content.drawString("bold italic text");
content.appendRawCommands("0 Tr\n");
content.endText();

content.close();

document.save("StyledTexts.pdf");
document.close();