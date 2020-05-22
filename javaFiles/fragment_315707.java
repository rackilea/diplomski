PDDocument doc = PDDocument.load(originalStream);
List<String> fontNames = prepareFont(doc, Arrays.asList(loadTrueTypeFont(doc, "LiberationSans-Regular.ttf"), PDType1Font.HELVETICA_BOLD));

setField(doc, "FirstName", "My first name", fontNames.get(0));
setField(doc, "LastName", "My last name", fontNames.get(1));

doc.save(new File(RESULT_FOLDER, "acroform-setFieldCustomStandard.pdf"));
doc.close();