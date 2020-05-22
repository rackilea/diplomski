PdfReader reader = new PdfReader("hello.pdf");
PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("hello_link.pdf"));
PdfAnnotation link = PdfAnnotation.createLink(stamper.getWriter(),
    new Rectangle(36, 790, 559, 806), PdfAnnotation.HIGHLIGHT_INVERT,
    new PdfAction("hello.pdf", 1));
stamper.addAnnotation(link, 1);
stamper.close();