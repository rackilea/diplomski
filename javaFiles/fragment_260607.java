SoapFaultDefinition soapFaultDefinition = new SoapFaultDefinition();
    String ENVELOPE_NAMESPACE_URI = "http://schemas.xmlsoap.org/soap/envelope/";
    QName FAULT_NAME = new QName(ENVELOPE_NAMESPACE_URI, "5999, "e");
    //      soapFaultDefinition.setFaultStringOrReason("--" + ex);
    //      soapFaultDefinition.setLocale(Locale.ENGLISH);
    soapFaultDefinition.setFaultCode(FAULT_NAME);
    super.setDefaultFault(soapFaultDefinition);