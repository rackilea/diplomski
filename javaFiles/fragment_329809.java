TransformerFactory factory = TransformerFactory.newInstance();
Templates template = factory.newTemplates(new StreamSource(new FileInputStream("xsl.xlt")));
Transformer xformer = template.newTransformer();
Source source = new StreamSource(new FileInputStream("in.xml"));
DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
Document doc = builder.newDocument();
Result result = new DOMResult(doc);
xformer.transform(source, result);