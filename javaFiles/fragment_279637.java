// JAXP reads data using the Source interface
Source xmlSource = new StreamSource(xmlFile);
Source xsltSource = new StreamSource(xsltFile);

// the factory pattern supports different XSLT processors
TransformerFactory transFact =
        TransformerFactory.newInstance();
Transformer trans = transFact.newTransformer(xsltSource);

trans.transform(xmlSource, new StreamResult(System.out));