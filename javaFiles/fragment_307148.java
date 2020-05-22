PDDocument source = PDDocument.load(resource);
PDDocument output = new PDDocument();
PDPage page = source.getPages().get(0);
output.addPage(page);
output.save(new File(RESULT_FOLDER, "PageAddedFromAnnotationSample.Standard.pdf"));
output.close();