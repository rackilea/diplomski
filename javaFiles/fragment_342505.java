PdfDocument pdfDocument = new PdfDocument(new PdfWriter(outFileName));
Document document = new Document(pdfDocument);
PdfFont font = PdfFontFactory.createFont(FONT_PATH, PdfEncodings.IDENTITY_H);
document.setProperty(Property.FONT, font);

String text1 = "Testing ligatures feature in layout (off): Fff akt ikto!";
Paragraph p = new Paragraph(text1);
document.add(p);

String text2 = "Testing ligatures feature in layout (on): Fff akt ikto!\nAnd also kerning: AWAWAWA";
Paragraph pLiga = new Paragraph(text2);
pLiga.setProperty(Property.TYPOGRAPHY_CONFIG, new TypographyConfigurator()
        .addFeatureConfig(
                new LatinScriptConfig()
                        .setLigaturesApplying(true)
                        .setKerningFeature(true)
        ));
document.add(pLiga);

document.close();