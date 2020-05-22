// Clean the html to use in the flying saucer converting tool
// get the element you want to serialize
HtmlCleaner cleaner = new HtmlCleaner();
TagNode rootTagNode = cleaner.clean(html);
// set up properties for the serializer (optional, see online docs)
CleanerProperties cleanerProperties = cleaner.getProperties();
// use the getAsString method on an XmlSerializer class
XmlSerializer xmlSerializer = new PrettyXmlSerializer(cleanerProperties);
String cleanedHtml = xmlSerializer.getAsString(rootTagNode);

// use the https://github.com/flyingsaucerproject/flyingsaucer to convert cleaned HTML to PDF
ITextRenderer renderer = new ITextRenderer();
renderer.setDocumentFromString(cleanedHtml);
// ....