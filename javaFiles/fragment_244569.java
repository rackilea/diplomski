String contents = "";
PDDocument doc = null;
try {
    doc = PDDocument.load(file);
    PDFTextStripper stripper = new PDFTextStripper();

    stripper.setLineSeparator("\n");
    stripper.setStartPage(1);
    stripper.setEndPage(5);// this mean that it will index the first 5 pages only
    contents = stripper.getText(doc);

} catch(Exception e){
    e.printStackTrace();
}