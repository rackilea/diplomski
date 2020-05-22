public void createPdf() {
    document = new Document();
    try {
        PdfWriter writer = PDFHead.getWriter(document);
        //If it's a letter we have a different indention on the top
        if (letterPDF) {
            document.setMargins(36, 36, 100, 36);
        } else {
            document.setMargins(36, 36, 36, 36);
        }
        document.open();
        document.add(createTabularContent());
        document.close();

    } catch (DocumentException | FileNotFoundException ex) {
        try {
            document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILENAME));
            document.open();
            document.add(new Phrase(ex.getLocalizedMessage()));
            document.close();
            Logger.getLogger(Etikette.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException | DocumentException ex1) {
            Logger.getLogger(Etikette.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }
}