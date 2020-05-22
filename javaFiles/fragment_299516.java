package com.test;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;

public class Main {
    public static void main(String... args) throws Exception {
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();

        String url = "http://www.webservicex.net/ConvertTemperature.asmx";
        SOAPMessage request = Main.createSOAPRequest();

        System.out.print("Request: ");
        request.writeTo(System.out);

        SOAPMessage response = soapConnection.call(request, url);

        System.out.print("\nResponse: ");
        response.writeTo(System.out);
    }

    private static SOAPMessage createSOAPRequest() throws Exception {
        SOAPMessage soapMessage = MessageFactory.newInstance().createMessage();

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", "http://www.webserviceX.NET/ConvertTemp");

        SOAPEnvelope envelope = soapMessage.getSOAPPart().getEnvelope();

        SOAPBody soapBody = envelope.getBody();
        soapBody.addNamespaceDeclaration("prefix", "http://www.webserviceX.NET/");

        SOAPElement convertTempElement = soapBody.addChildElement("ConvertTemp", "prefix");

        SOAPElement temperatureElement = convertTempElement.addChildElement("Temperature", "prefix");
        temperatureElement.addTextNode("100");

        SOAPElement fromUnitElement = convertTempElement.addChildElement("FromUnit", "prefix");
        fromUnitElement.addTextNode("degreeCelsius");

        SOAPElement toUnitElement = convertTempElement.addChildElement("ToUnit", "prefix");
        toUnitElement.addTextNode("degreeFahrenheit");

        soapMessage.saveChanges();
        return soapMessage;
    }
}