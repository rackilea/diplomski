package hello;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

import hello.wsdl.SetPinCode;
import hello.wsdl.SetPinCodeResponse;

public class SetPinCodeClient extends WebServiceGatewaySupport{

private static final Logger log = LoggerFactory.getLogger(SetPinCodeClient.class);

public SetPinCodeResponse SetPinCode(JAXBElement<String> pinCode, JAXBElement<String> cardNumber, JAXBElement<Integer> casinoCreationId) throws SOAPException {
    String action ="http://tempuri.org/Player_x0020_Management_x0020_Service/SetPinCode";
    String uri = "http://xxx.xxx.xx.x/PlayerServices/PlayerIntelligence/PlayerManagementService";

    SetPinCode request = new SetPinCode();
    request.setPinCode(pinCode);
    request.setCardNumber(cardNumber);
    request.setCasinoCreationId(casinoCreationId);

    log.info("Requesting save in database for card " + cardNumber + "with pin code" + pinCode + "from casino n°" + casinoCreationId);

    MessageFactory msgFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
    SaajSoapMessageFactory saajSoapMessageFactory = new SaajSoapMessageFactory(msgFactory);
    WebServiceTemplate wsTemplate = getWebServiceTemplate();
    wsTemplate.setMessageFactory(saajSoapMessageFactory);

    SoapActionCallback requestCallback = new SoapActionCallback(action) {
        public void doWithMessage(WebServiceMessage message) {
            SaajSoapMessage soapMessage = (SaajSoapMessage) message;
            SoapHeader soapHeader = soapMessage.getSoapHeader();

            QName wsaToQName = new QName("http://www.w3.org/2005/08/addressing", "To", "wsa");
            SoapHeaderElement wsaTo =  soapHeader.addHeaderElement(wsaToQName);
            wsaTo.setText(uri);

            QName wsaActionQName = new QName("http://www.w3.org/2005/08/addressing", "Action", "wsa");
            SoapHeaderElement wsaAction =  soapHeader.addHeaderElement(wsaActionQName);
            wsaAction.setText(action);
        }
    };

    SetPinCodeResponse response = (SetPinCodeResponse) wsTemplate.marshalSendAndReceive(uri, request, requestCallback);

    return response;


}
}