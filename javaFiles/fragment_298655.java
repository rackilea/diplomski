public WordprocessingMLPackage export(String xhtml) {

WordprocessingMLPackage wordMLPackage = null;
try {
    RFonts arialRFonts = Context.getWmlObjectFactory().createRFonts();
    arialRFonts.setAscii("Arial");
    arialRFonts.setHAnsi("Arial");
    XHTMLImporterImpl.addFontMapping("Arial", arialRFonts);

    wordMLPackage = WordprocessingMLPackage.createPackage();
    XHTMLImporter importer = new XHTMLImporterImpl(wordMLPackage);
    List<Object> content = importer.convert(xhtml,null);
    wordMLPackage.getMainDocumentPart().getContent().addAll(content);
}
catch (Docx4JException e) {
    // ...
}
return wordMLPackage;
}