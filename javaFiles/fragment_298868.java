ByteArrayOutputStream generatePdfFromStringImproved(String content) throws IOException {
    try (   PDDocument doc = new PDDocument();
            InputStream notoSansRegularResource = AddTextWithDynamicFonts.class.getResourceAsStream("NotoSans-Regular.ttf");
            InputStream notoSansCjkRegularResource = AddTextWithDynamicFonts.class.getResourceAsStream("NotoSansCJKtc-Regular.ttf")   ) {
        PDType0Font notoSansRegular = PDType0Font.load(doc, notoSansRegularResource);
        PDType0Font notoSansCjkRegular = PDType0Font.load(doc, notoSansCjkRegularResource);
        List<PDFont> fonts = Arrays.asList(notoSansRegular, notoSansCjkRegular);

        List<TextWithFont> fontifiedContent = fontify(fonts, content);

        PDPage page = new PDPage();
        doc.addPage(page);
        try (   PDPageContentStream contentStream = new PDPageContentStream(doc, page)) {
            contentStream.beginText();
            for (TextWithFont textWithFont : fontifiedContent) {
                textWithFont.show(contentStream, 12);
            }
            contentStream.endText();
        }
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        doc.save(os);
        return os;
    }
}