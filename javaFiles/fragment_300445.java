import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;

import org.apache.axis.client.Stub;
import org.apache.axis.message.PrefixedQName;
import org.apache.axis.message.SOAPHeaderElement;

public class SoapHeaderCreator {
    /**
     * 
     * @param stub
     * @param user
     * @param password
     * @throws SOAPException
     */
    public static void addAuthenticationOASIS(Stub stub, String user, String password) throws SOAPException{
        //Define security header
        QName qname = new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd","Security","wsse");
        SOAPHeaderElement header = new SOAPHeaderElement(qname);
        String token = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText";
        header.setMustUnderstand(true);
//      header.setActor("");
        SOAPElement node = header.addChildElement("UsernameToken");         
        SOAPElement node2 = node.addChildElement("Username");
        node2.addTextNode(user);
        SOAPElement node3 = node.addChildElement("Password");
        node3.addTextNode(password);
        PrefixedQName name = new PrefixedQName("", "Type", "");
        node3.addAttribute(name, token);
        stub.setHeader(header);
    }
}