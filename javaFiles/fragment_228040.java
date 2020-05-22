SAXTransformerFactory stf = (SAXTransformerFactory)TransformerFactory.newInstance();

// These templates objects could be reused and obtained from elsewhere.
Templates templates1 = stf.newTemplates(new StreamSource(
  getClass().getResourceAsStream("MyStylesheet1.xslt")));
Templates templates2 = stf.newTemplates(new StreamSource(
  getClass().getResourceAsStream("MyStylesheet1.xslt")));

TransformerHandler th1 = stf.newTransformerHandler(templates1);
TransformerHandler th2 = stf.newTransformerHandler(templates2);

th1.setResult(new SAXResult(th2));
th2.setResult(new StreamResult(System.out));

Transformer t = stf.newTransformer();
t.transform(new StreamSource(System.in), new SAXResult(th1));

// th1 feeds th2, which in turn feeds System.out.