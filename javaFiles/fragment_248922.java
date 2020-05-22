public void getWSDLDefinition(byte[] wsdl) {
        try {
            WSDLReader wsdlReader = javax.wsdl.factory.WSDLFactory.newInstance().newWSDLReader();
            // switch off the verbose mode
            wsdlReader.setFeature(JAVAX_WSDL_VERBOSE_MODE, false);
            wsdlReader.setFeature("javax.wsdl.importDocuments", false);
            Definition wsdlDefinition = wsdlReader.readWSDL(null, new InputSource(new ByteArrayInputStream(wsdl)));
        } catch (Exception e) {}
    }