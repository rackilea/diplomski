final QName qname = new QName(Settings.MAIN_SCAN_SERVICE_SOAP_URL.get().toString(), "PortName");
    final String wsdlUrl = Settings.MAIN_SCAN_SERVICE_WSDL_URL.get().toString();

    final JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
    jaxWsProxyFactoryBean.setAddress(Settings.MAIN_SCAN_SERVICE_SOAP_URL.get().toString());
    jaxWsProxyFactoryBean.setEndpointName(qname);
    jaxWsProxyFactoryBean.setServiceName(new QName(wsdlUrl, "PortName"));
    jaxWsProxyFactoryBean.setWsdlLocation(wsdlUrl);
    jaxWsProxyFactoryBean.setServiceClass(PortImpl.class);
    this.portImpl = (PortImpl) jaxWsProxyFactoryBean.create();