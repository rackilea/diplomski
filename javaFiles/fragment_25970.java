/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvstest;


import dvs.common._2014._06.contract.data.Gender;
import dvs.common._2014._06.contract.data.RegistrationState;
import dvs.common._2014._06.contract.data.manager.*;
import dvs.common._2014._06.contract.service.manager.IVerification;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.cxf.ws.addressing.WSAddressingFeature;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Sadiq
 */
public class DVSTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            // These params are used to print the soap request going in and out.
            System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
            System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
            System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
            System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");

            //Path to java keystore which holds the ssl certificate, might come in handy later on.
            /*String trustStoreFile = "C:\\Program Files\\Java\\jdk1.8.0_131\\jre\\lib\\security\\cacerts";
            String trustStorePassword = "changeit";


            System.setProperty("javax.net.ssl.trustStore", trustStoreFile);
            System.setProperty("javax.net.ssl.trustStorePassword", trustStorePassword);
            System.setProperty("javax.net.ssl.trustStoreType", "JKS");
            System.setProperty("sun.security.ssl.allowUnsafeRenegotiation", "true");*/


            /*
            This is how we can extra namespaces if needed.

            Map<String, String> nsMap = new HashMap();

            nsMap.put("wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
            nsMap.put("wsu", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
            nsMap.put("man", "http://DVS/Common/2014/06/Contract/Service/Manager");
            nsMap.put("man1", "http://DVS/Common/2014/06/Contract/Data/Manager");
            nsMap.put("ds", "http://www.w3.org/2000/09/xmldsig#");
            nsMap.put("ec", "http://www.w3.org/2001/10/xml-exc-c14n#");

            client.getRequestContext().put("soap.env.ns.map", nsMap);
            */


            //Creating a factory and setting the service interface using which we can make soap requests.
            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(IVerification.class);

            //Path to endpoint
            //You can get this path by looking inside the wsdl
            factory.setAddress("https://urlhere/Https");

            //Pointing the post request to be soap12 compliant
            factory.setBindingId("http://schemas.xmlsoap.org/wsdl/soap12/");

            //Adding address feature to the outgoing request, this will add <To><MessageId><ReplyTo> part to soap request.
            factory.getFeatures().add(new WSAddressingFeature());

            //Creating a port for the verification interface using the factory.
            IVerification port = (IVerification) factory.create();

            //Creating client, this will be used to specify various outgoing props.
            Client client = ClientProxy.getClient(port);

            //Setting content type and creating a conduit.
            HTTPConduit http = (HTTPConduit) client.getConduit();
            HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
            httpClientPolicy.setContentType("application/soap+xml");
            http.setClient(httpClientPolicy);

            //Endpoint fetched using client
            Endpoint cxfEndpoint = client.getEndpoint();

            //Setting cfx related props
            Map<String, Object> outProps = new HashMap<String, Object>();
            outProps.put(WSHandlerConstants.ACTION, "Signature Timestamp");
            outProps.put(WSHandlerConstants.USER, "myalias");
            outProps.put(WSHandlerConstants.SIG_PROP_FILE, "client_sign.properties");
            //Used to add the digest part to the soap post request
            outProps.put(WSHandlerConstants.SIG_KEY_ID, "DirectReference");
            //Used to sign the <To> element.
            outProps.put(WSHandlerConstants.SIGNATURE_PARTS, "{Element}{http://www.w3.org/2005/08/addressing}To");
            // Password type : plain text
            outProps.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
            // for hashed password use:
            //properties.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_DIGEST);
            // Callback used to retrieve password for given user.
            outProps.put(WSHandlerConstants.PW_CALLBACK_CLASS,
                    ClientPasswordCallback.class.getName());

            //Setting props to post request.
            WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps);
            cxfEndpoint.getOutInterceptors().add(wssOut);


            System.out.println(passportRequest(port).getVerificationResultCode());

            System.out.println(driverLicenseRequest(port).getVerificationResultCode());



        } catch (Exception ex) {
            Logger.getLogger(DVSTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Sets properties to PassportRequest and makes a soap request using the IVerification object.
     *
     * @param port Needs a IVerification object created by the factory.
     * @return VerificationResponse as a response of soap request.
     * @throws Exception
     */
    public static VerificationResponse passportRequest(IVerification port) throws Exception {

        //Creating a passport request
        PassportRequest request = new PassportRequest();

        //Creating a DVSDate object and the creating a jaxb element to be assigned to the PassportRequest object.
        DVSDate date = new DVSDate();
        date.setDay(1);
        date.setMonth(1);
        date.setYear(2017);
        ObjectFactory objectFactory = new ObjectFactory();
        JAXBElement<DVSDate> documentRequest = objectFactory.createDVSDate(date);
        request.setBirthDate(documentRequest);

        request.setDocumentTypeCode(DocumentType.PP);
        JAXBElement<String> familyName = objectFactory.createCertificateRequestFamilyName2("D");
        request.setFamilyName(familyName);
        JAXBElement<String> givenName = objectFactory.createCertificateRequestGivenName2("T");
        request.setGivenName(givenName);
        request.setOriginatingAgencyCode("1");
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(new Date(System.currentTimeMillis()));
        XMLGregorianCalendar requestDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        request.setRequestDateTime(requestDate);
        request.setVerificationRequestNumber("1");
        request.setVersionNumber("1");
        JAXBElement<Gender> gender = objectFactory.createPassportRequestGender(Gender.M);
        request.setGender(gender);
        request.setTravelDocumentNumber("1");

        return port.verifyDocument(request);
    }

    /**
     * Sets properties to DriverLicenseRequest and makes a soap request using the IVerification object.
     *
     * @param port Needs a IVerification object created by the factory.
     * @return VerificationResponse as a response of soap request.
     * @throws Exception
     */
    public static VerificationResponse driverLicenseRequest(IVerification port) throws Exception {

        //Creating a passport request
        DriverLicenceRequest request = new DriverLicenceRequest();

        //Creating a DVSDate object and the creating a jaxb element to be assigned to the PassportRequest object.
        DVSDate date = new DVSDate();
        date.setDay(1);
        date.setMonth(1);
        date.setYear(2017);
        ObjectFactory objectFactory = new ObjectFactory();
        JAXBElement<DVSDate> documentRequest = objectFactory.createDVSDate(date);
        request.setBirthDate(documentRequest);

        request.setDocumentTypeCode(DocumentType.DL);
        JAXBElement<String> familyName = objectFactory.createCertificateRequestFamilyName2("D");
        request.setFamilyName(familyName);
        JAXBElement<String> givenName = objectFactory.createCertificateRequestGivenName2("T");
        request.setGivenName(givenName);
        request.setOriginatingAgencyCode("1");
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(new Date(System.currentTimeMillis()));
        XMLGregorianCalendar requestDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        request.setRequestDateTime(requestDate);
        request.setVerificationRequestNumber("1");
        request.setVersionNumber("1");
        request.setLicenceNumber("1");
        JAXBElement<String> middleName = objectFactory.createDriverLicenceRequestMiddleName("Joseph");
        request.setMiddleName(middleName);

        dvs.common._2014._06.contract.data.ObjectFactory objectFactoryData = new dvs.common._2014._06.contract.data.ObjectFactory();
        JAXBElement<RegistrationState> registrationState = objectFactoryData.createRegistrationState(RegistrationState.NSW);
        request.setStateOfIssue(registrationState.getValue());
        JAXBElement<Gender> gender = objectFactory.createPassportRequestGender(Gender.M);




        return port.verifyDocument(request);
    }


}