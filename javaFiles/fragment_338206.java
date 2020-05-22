XWPFDocument document = new XWPFDocument(PoiTest.class.getResourceAsStream("twocolumn.docx"));
    XWPFParagraph tmpParagraph = document.getParagraphs().get(0);

    for (int i = 0; i < 100; i++) {
        XWPFRun tmpRun = tmpParagraph.createRun();
        tmpRun.setText("LALALALAALALAAAA");
        tmpRun.setFontSize(18);
    }
    document.write(new FileOutputStream(new File("C:\\temp\\poi.docx")));