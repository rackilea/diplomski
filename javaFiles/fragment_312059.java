private static String FILE = "../print2.pdf";   

    try {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(FILE));
        document.open();            
         //This is title.
        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);
        document.add(preface);
        preface.add(new Paragraph("This is cupcake.", catFont));
        addTitlePage(document);
        // This is content.
        Anchor anchor = new Anchor(AddSalesPromoController.tempPromoName.getText(), catFont);
        anchor.setName("First Chapter");
        document.close();
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File("../print2.pdf");
                Desktop.getDesktop().open(myFile);
            } catch (Exception ex) {
                ModelUtil.getAlert("Not supported", "not supported", Alert.AlertType.ERROR);
                // no application registered for PDFs
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }