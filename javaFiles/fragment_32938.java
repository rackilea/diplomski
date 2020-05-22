final InputStream xsltStream = getClass().getResourceAsStream("/eu/deniss/report/view/xslt/someFile.xslt");

Source xsltSource = new StreamSource(xsltStream);

// for performance optimizations  
Templates cached = factory.newTemplates(xsltSource);
Transformer transformer = cached.newTransformer();