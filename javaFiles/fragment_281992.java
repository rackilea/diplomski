public void translate(InputStream xmlStream, InputStream styleStream, OutputStream resultStream) {
        Source source = new StreamSource(xmlStream);
        Source style = new StreamSource(styleStream);
        Result result = new StreamResult(resultStream);

        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer t = tFactory.newTransformer(style);
        t.transform(source, result);
    }