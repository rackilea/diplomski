PDDocument document = null;
    document = PDDocument.load(pdf1);

    int pageNum = document.getNumberOfPages();

    PDFImageWriter writer = new PDFImageWriter();
    String filename = pdf1.getPath() + "-";
    filename = filename.replace(".pdf", "");
    writer.writeImage(document, "png", "", 1, Integer.MAX_VALUE, filename);

    document.close();