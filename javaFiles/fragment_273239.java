PdfDocument doc = new PdfDocument();
doc.load("Input_Docs\\input_doc.pdf");

// Obtain all website addresses in page 2
ArrayList lstSearchResults =
   (ArrayList) doc.search("http://{1}",  // regular expression
                          2, // page number
                          PdfSearchMode.REGEX,
                          PdfSearchOptions.NONE);