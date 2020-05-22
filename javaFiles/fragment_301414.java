PDDocument templatedoc = PDDocument.load(new File(path));           
PDDocumentCatalog catalog = templatedoc.getDocumentCatalog();           

PDAcroFrom acroForm = catalog.getAcroForm());

... fill acroForm common data of all pages ...

ByteArrayOutputStream basicTemplate = new ByteArrayOutputStream();          
templatedoc.save(basicTemplate);

byte[] filledBasicTemplate = basicTemplate.toByteArray();