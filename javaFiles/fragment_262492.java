public static File fontFile = new File("fonts/arialuni.ttf");

    public static void createITextDocument(File from, File to) throws DocumentException, IOException {

        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(to));
        document.open();
        writer.getAcroForm().setNeedAppearances(true);
        BaseFont unicode = BaseFont.createFont(fontFile.getAbsolutePath(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

        FontSelector fs = new FontSelector();
        fs.addFont(new Font(unicode));

        addContent(document, getParagraphs(from), fs);
        document.close();
    }

    private static void addContent(Document document, List<String> paragraphs, FontSelector fs) throws DocumentException { 

        for (int i = 0; i < paragraphs.size(); i++) {
            Phrase phrase = fs.process(paragraphs.get(i));
            document.add(new Paragraph(phrase));
        }
    }