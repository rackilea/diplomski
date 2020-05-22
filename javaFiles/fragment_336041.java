private static final ThreadLocal<DocumentBuilder> builderLocal =
    new ThreadLocal<DocumentBuilder>() {
        @Override protected DocumentBuilder initialValue() {
            try {
                return
                    DocumentBuilderFactory
                        .newInstance(
                            "xx.MyDocumentBuilderFactory",
                            getClass().getClassLoader()
                        ).newDocumentBuilder();
            } catch (ParserConfigurationException exc) {
                throw new IllegalArgumentException(exc);
            }
        }
    };