private void setResponseHeaderPDF(HttpServletResponse response) {
    response.setContentType("application/pdf");
    response.setHeader("content-disposition", "attachment; filename=imenik.pdf" );
} 

@RequestMapping(value = "/exportPhonebook.html", method = RequestMethod.POST)
public void exportPhonebook(Model model, @RequestParam("buttonSpremiImenik") String buttonSpremiImenik, HttpServletResponse response, HttpServletRequest request) {

    try {
        setResponseHeaderPDF(response);
        Document document = new Document();
        ByteArrayOutputStream baosPDF = new ByteArrayOutputStream();
        PdfWriter pdfWriter = null;
        pdfWriter = PdfWriter.getInstance(document, baosPDF);
        document.open();
        addMetaData(document);
        addTitlePage(document);
        addContent(document);
        document.close();
        pdfWriter.close();
        OutputStream os = response.getOutputStream();
        baosPDF.writeTo(os);
        os.flush();
        os.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.BOLD);
private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.BOLD);
private static Font tableHeaderFont = new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.BOLD);
public static String[][] FONTS = {{"c:/windows/fonts/arial.ttf", BaseFont.IDENTITY_H}};


private static void addMetaData(Document document) {
    document.addTitle("Phonebook");
    document.addSubject("phonebook");
    document.addKeywords("phonebook");
    document.addAuthor("John Smith");
    document.addCreator("John Smith");
}
private static void addTitlePage(Document document) throws DocumentException {
    Paragraph preface = new Paragraph();
    addEmptyLine(preface, 1);
    preface.add(new Paragraph("Phonebook", catFont));
    addEmptyLine(preface, 1);
    preface.add(new Paragraph("Generated: " + new Date(), smallBold));
    addEmptyLine(preface, 1);
    document.add(preface);
}

private void addContent(Document document) throws DocumentException {

    Paragraph paragraph = new Paragraph();
    addEmptyLine(paragraph, 1);

    // Add a table
    createTable(paragraph);

    // Now add all this to the document
    document.add(paragraph);
}


private static void addEmptyLine(Paragraph paragraph, int number) {
    for (int i = 0; i < number; i++) {
        paragraph.add(new Paragraph(" "));
    }
}
private void createTable(Paragraph paragraf) throws DocumentException {

    PdfPTable table = new PdfPTable(9);
    table.setTotalWidth(new float[]{ 58, 50, 95, 60, 60, 135, 60, 42, 30 });
    table.setLockedWidth(true);

    List<User> listOfAllUsers = phoneBookSer.fetchAllUsers();

    PdfPCell c1 = new PdfPCell(new Phrase("Prezime", tableHeaderFont));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(c1);

    c1 = new PdfPCell(new Phrase("Ime", tableHeaderFont));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(c1);

    c1 = new PdfPCell(new Phrase("Organizacijska jedinica", tableHeaderFont));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(c1);

    c1 = new PdfPCell(new Phrase("Telefon", tableHeaderFont));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(c1);

    c1 = new PdfPCell(new Phrase("Telefaks", tableHeaderFont));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(c1);

    c1 = new PdfPCell(new Phrase("E-mail", tableHeaderFont));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(c1);

    c1 = new PdfPCell(new Phrase("Lokacija", tableHeaderFont));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(c1);

    c1 = new PdfPCell(new Phrase("Kat", tableHeaderFont));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(c1);

    c1 = new PdfPCell(new Phrase("Soba", tableHeaderFont));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(c1);

    table.setHeaderRows(1);


    BaseFont bf = null;
    try {
        bf = BaseFont.createFont(FONTS[0][0], FONTS[0][1], BaseFont.EMBEDDED);
    } catch (IOException e) {
        e.printStackTrace();
    }
    Font fontArial = new Font(bf, 9);

    //Automatically detects fonts
    //FontFactory.registerDirectories();
    //Font fontArial9 = FontFactory.getFont("Arial", 9);

    for (User user : listOfAllUsers) {
        PdfPCell cell1 = new PdfPCell(new Phrase(user.getPrezime(), fontArial));
        table.addCell(cell1);
        PdfPCell cell2 = new PdfPCell(new Phrase(user.getIme(), fontArial));
        table.addCell(cell2);
        PdfPCell cell3 = new PdfPCell(new Phrase(user.getOrganizacijskaJedinica(), fontArial));
        table.addCell(cell3);
        PdfPCell cell4 = new PdfPCell(new Phrase(user.getTelefon(), fontArial));
        table.addCell(cell4);
        PdfPCell cell5 = new PdfPCell(new Phrase(user.getTelefaks(), fontArial));
        table.addCell(cell5);
        PdfPCell cell6 = new PdfPCell(new Phrase(user.getEmail(), fontArial));
        table.addCell(cell6);
        PdfPCell cell7 = new PdfPCell(new Phrase(user.getLokacija(), fontArial));
        table.addCell(cell7);
        PdfPCell cell8 = new PdfPCell(new Phrase(user.getKat(), fontArial));
        table.addCell(cell8);
        PdfPCell cell9 = new PdfPCell(new Phrase(user.getBrojSobe(), fontArial));
        table.addCell(cell9);
    }

    paragraf.add(table);
}