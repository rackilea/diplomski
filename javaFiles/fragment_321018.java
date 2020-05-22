PDDocument document = PDDocument.load(new File("target.pdf"));
PDFTextStripperByArea stripper = new PDFTextStripperByArea();
stripper.setSortByPosition(true);
Rectangle rect = new Rectangle(35, 375, 340, 204);
stripper.addRegion("class1", rect);
stripper.extractRegions(document.getPage(1));
System.out.println(stripper.getTextForRegion("class1")