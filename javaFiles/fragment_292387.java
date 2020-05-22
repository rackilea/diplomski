// create a new document
 PdfDocument document = new PdfDocument();

 // crate a page description
 PageInfo pageInfo = new PageInfo.Builder(new Rect(0, 0, 100, 100), 1).create();

 // start a page
 Page page = document.startPage(pageInfo);

 // draw something on the page
 View content = getContentView();
 content.draw(page.getCanvas());

 // finish the page
 document.finishPage(page);
 . . .
 // add more pages
 . . .
 // write the document content
 document.writeTo(getOutputStream());

 // close the document
 document.close();