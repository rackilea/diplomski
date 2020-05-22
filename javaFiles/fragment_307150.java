PDDocument source = PDDocument.load(resource);
Splitter splitter = new Splitter();
List<PDDocument> results = splitter.split(source);
Assert.assertEquals("Expected exactly one result document from splitting a single page document.", 1, results.size());
PDDocument output = results.get(0);
output.save(new File(RESULT_FOLDER, "PageSplitFromAnnotationSample.Standard.pdf"));
output.close();