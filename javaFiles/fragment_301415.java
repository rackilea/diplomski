List<PDDocument> documents = new ArrayList<PDDocument>();
PDDocument activeDoc;

for(int i = 0; i < 5; i++) {
  activeDoc = PDDocument.load(filledBasicTemplate);
  documents.add(activeDoc);

  ... fill acroform or you need in each page ...

}