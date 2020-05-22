PDDocument source = PDDocument.load(resource);
PDDocument output = new PDDocument();
PDPage page = source.getPages().get(0);
output.importPage(page);
output.save(new File(RESULT_FOLDER, "PageImportedFromAnnotationSample.Standard.pdf"));
output.close();