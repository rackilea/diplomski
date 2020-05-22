public void translate(InputStream xmlStream, OutputStream resultStream) {
        Source source = new StreamSource(xmlStream);
        Result result = new StreamResult(resultStream);

        Translet t = new YourTransletClass();
        t.transform(source, result);
    }