Validator validator = SchemaFactory
                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
                .newSchema(new StreamSource(new StringReader(xsd)))
                .newValidator();
        LoggingErrorHandler errorHandler = new LoggingErrorHandler();
        validator.setErrorHandler(errorHandler);
        validator.validate(new StreamSource(new StringReader(xml)));
        return errorHandler.isValid();