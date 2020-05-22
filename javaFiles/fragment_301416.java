PDDocument finalDoc = new PDDocument();

for(PDDocument currentDoc : documents) {
   ... fill common things like page numbers ...
   finalDoc.importPage(currentDoc.getPage(0));
}

finalDoc.save(new File(path));


... close all documents after save the final document ...