package com.stg.pack;

@ServiceMode(value = Service.Mode.MESSAGE)
@WebServiceProvider(portName = "ThePortNameOfWebService", 
        serviceName = "TheNameOfWebService", 
        targetNamespace = "http://www.example.com/target/namespace/uri")
public class MyServiceProvider implements Provider<SOAPMessage> {

    @Override
    public SOAPMessage invoke(SOAPMessage request) {
        SOAPMessage result = null;
        // create response SOAPMessage
        return result;
    }
}