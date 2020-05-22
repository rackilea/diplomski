//  activating Headings property for MS Word Heading Mapping
ImportXHTMLProperties.setProperty("docx4j-ImportXHTML.Element.Heading.MapToStyle", true);
ordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage(PageSizePaper.LETTER, false);

XHTMLImporterImpl XHTMLImporter = new XHTMLImporterImpl(wordMLPackage);
XHTMLImporter.setRunFormatting(FormattingOption.CLASS_PLUS_OTHER);
NumberingDefinitionsPart ndp = new NumberingDefinitionsPart();

wordMLPackage.getMainDocumentPart().addTargetPart(ndp);
ndp.unmarshalDefaultNumbering();

wordMLPackage.getMainDocumentPart().getContent().addAll(XHTMLImporter.convert("<h3> SAMPLE HEADING</h3>", null));

File exportFile = new File(somepath/sample.docx);
// adding TOC - TABLE OF CONTENTS
TocGenerator tocGenerator = new TocGenerator(wordMLPackage);
tocGenerator.generateToc(0, "TOC \\o \"1-3\" \\h \\z \\u ", false);

wordMLPackage.save(exportFile);