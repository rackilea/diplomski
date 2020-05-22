PicturesSource pictures = new PicturesSource(document);
PicturesTable pictureTable = document.getPicturesTable();

Range r = document.getRange();
for(int i=0; i<r.numParagraphs(); i++) {
    Paragraph p = r.getParagraph(i);
    for(int j=0; j<p.numCharacterRuns(); j++) {
      CharacterRun cr = p.getCharacterRun(j);
      if (pictureTable.hasPicture(cr)) {
         Picture picture = pictures.getFor(cr);
         // Do something useful with the picture
      }
    }
}