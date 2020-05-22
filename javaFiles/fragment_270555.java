Document stylesheetDoc = loadStylesheetDoc(stylesheet);
    // load the transformer using JAXP
    TransformerFactory factory = TransformerFactory.newInstance();
    Transformer transformer = factory.newTransformer( 
        new DOMSource( stylesheetDoc ) 
    );