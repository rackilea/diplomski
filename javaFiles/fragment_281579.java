package com.foo.tests;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;
import java.util.UUID;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPMessage;

import org.w3c.dom.Document;

public class TestSOAPMessage {

    static MessageFactory factory;
    static DocumentBuilderFactory documentFactory;
    static JAXBContext jaxbCtx;
    static com.foo.tests.pojo.ObjectFactory myStuffFactory = new com.foo.tests.pojo.ObjectFactory();
    static {
        try {
            factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);
            documentFactory = DocumentBuilderFactory.newInstance();
            jaxbCtx = JAXBContext.newInstance(com.foo.tests.pojo.MyStuffPojo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String... args) {
        try {
            // prepare test MyStuff JAXB POJO
            com.foo.tests.pojo.MyStuffPojo myStuff = myStuffFactory.createMyStuffPojo();
            // populate myStuff Pojo
            myStuff.setMyPropertyA("property A");
            myStuff.setTimestamp(Calendar.getInstance());
            myStuff.setMessageId(UUID.randomUUID().toString());
            //---
            // marshal JAXB Pojo to DOM Document
            Document myStuffDoc = documentFactory.newDocumentBuilder().newDocument();

            //*** myStuff has @XmlRootElement annotation
             jaxbCtx.createMarshaller().marshal(myStuff, myStuffDoc);

            //*** myStuff does not have @XmlRootElement annotation wrap it and use JAXBElement instead
//          JAXBElement<com.foo.tests.pojo.MyStuffPojo myStuff> jaxbWrapper = myStuffFactory.createMyStuffPojo(myStuff);
//          jaxbCtx.createMarshaller().marshal(jaxbWrapper, myStuffDoc);

            //marshal JAXB Pojo to DOM Document 
            Document myStuffDoc = documentFactory.newDocumentBuilder().newDocument();
            jaxbCtx.createMarshaller().marshal(jaxbWrapper, myStuffDoc);
            //Create SOAPMessage
            SOAPMessage myMessage = factory.createMessage();
            //Optional if we'd like to set those properties...
            myMessage.setProperty(SOAPMessage.WRITE_XML_DECLARATION, "true");
            myMessage.setProperty(SOAPMessage.CHARACTER_SET_ENCODING, "utf-8");
            // set myStuff into SOAPBody
            myMessage.getSOAPBody().addDocument(myStuffDoc);        
            //All done. Save changes
            myMessage.saveChanges();

            // Just for test: print message
            ByteArrayOutputStream finalBos = new ByteArrayOutputStream();
            myMessage.writeTo(finalBos);
            System.out.println("my Message: \r\n" + new String(finalBos.toByteArray()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}