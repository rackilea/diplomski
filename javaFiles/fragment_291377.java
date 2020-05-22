PDDocument doc = PDDocument.load(new File("test.pdf"));
PrinterJob job = PrinterJob.getPrinterJob();

// define custom paper
Paper paper = new Paper();
paper.setSize(306, 396); // 1/72 inch
paper.setImageableArea(0, 0, paper.getWidth(), paper.getHeight()); // no margins

// custom page format
PageFormat pageFormat = new PageFormat();
pageFormat.setPaper(paper);

// override the page format
Book book = new Book();
// append all pages
book.append(new PDFPrintable(doc, Scaling.SHRINK_TO_FIT), pageFormat, doc.getNumberOfPages());
job.setPageable(book);

job.print();