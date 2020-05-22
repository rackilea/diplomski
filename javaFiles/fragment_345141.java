//...

TransformerFactory factory = TransformerFactory.newInstance();
Source xslt = new StreamSource(new File("Resume.xslt"));
Transformer transformer = factory.newTransformer(xslt);

SAXParser parser = saxParserFactory.newSAXParser();
XMLSkipResumeFilter reader = new XMLSkipResumeFilter(parser.getXMLReader(), resumeIdsToLeave);
InputStream is = new FileInputStream("Resume.xml");
Source text = new SAXSource(filter, is);

transformer.transform(text, new StreamResult(new File("ResumeAll.html")));

//...