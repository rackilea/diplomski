Boolean retVal = doSendAndReceive(uri, transformer, requestPayload, requestCallback,
                new SourceExtractor<Boolean>() {

                    public Boolean extractData(Source source) throws IOException, TransformerException {
                        if (source != null) {
                            transformer.transform(source, responseResult);
                        }
                        return Boolean.TRUE;
                    }
                });