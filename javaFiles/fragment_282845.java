import java.io.ByteArrayInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

public class XPathClass {
    public static void main(String[] args) throws Exception {
        String soapXML = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">    <soapenv:Body>        <Request xmlns:xacml-context=\"urn:oasis:names:tc:xacml:2.0:context:schema:os\" xmlns:ns9=\"urn:oasis:xacml:2.0:saml:assertion:schema:os\" xmlns:ns8=\"urn:oasis:xacml:2.0:saml:protocol:schema:os\" xmlns:ns7=\"http://security.bea.com/ssmws/ssm-soap-types-1.0.xsd\" xmlns:ns6=\"http://www.w3.org/2001/04/xmlenc#\" xmlns:ns5=\"urn:oasis:names:tc:xacml:2.0:policy:schema:os\" xmlns:ns4=\"urn:oasis:names:tc:xacml:2.0:context:schema:os\" xmlns:ns3=\"urn:oasis:names:tc:SAML:2.0:protocol\" xmlns:ns2=\"http://www.w3.org/2000/09/xmldsig#\" xmlns=\"urn:oasis:names:tc:xacml:2.0:context:schema:os\">            <Subject>                <Attribute AttributeId=\"urn:oasis:names:tc:xacml:1.0:subject:subject-id\" DataType=\"http://security.bea.com/ssmws/ssm-ws-1.0.wsdl#OESPrincipalInfo\">                    <AttributeValue>{name=jimlum1234}+(class=weblogic.security.principal.WLSUserImpl)</AttributeValue>                </Attribute><!-- FOLLOWING IS **THE** GOOD WAY AND DOES WORK WITH OES FOR ROLE --><Attribute AttributeId=\"http://oracle.com/symbols/oes/attribute/group-assertion\" DataType=\"http://security.bea.com/ssmws/ssm-ws-1.0.wsdl#OESPrincipalInfo\" xsi:type=\"ns1:AttributeType\"> <AttributeValue xsi:type=\"ns1:AttributeValueType\">{name=Operators}+(class=weblogic.security.principal.WLSGroupImpl)</AttributeValue> </Attribute>             </Subject>            <Resource>                <Attribute AttributeId=\"urn:oasis:names:tc:xacml:2.0:resource:resource-id\" DataType=\"http://www.w3.org/2001/XMLSchema#string\">                    <AttributeValue>foo/foo1/foo2</AttributeValue>                </Attribute>            </Resource>            <Action>                <Attribute AttributeId=\"urn:oasis:names:tc:xacml:1.0:action:action-id\" DataType=\"http://www.w3.org/2001/XMLSchema#string\">                    <AttributeValue>GET</AttributeValue>                </Attribute>            </Action><ns4:Environment xsi:type=\"ns4:EnvironmentType\"      xmlns:ns4=\"urn:oasis:names:tc:xacml:2.0:context:schema:os\"      xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">  <ns4:Attribute AttributeId=\"http://security.bea.com/ssmws/ssm-ws-1.0.wsdl#RegisteredAttribute\"      DataType=\"http://www.w3.org/2001/XMLSchema#string\" xsi:type=\"ns4:AttributeType\">    <ns4:AttributeValue xsi:type=\"ns4:AttributeValueType\">4444444444yes</ns4:AttributeValue>   </ns4:Attribute>  <ns4:Attribute AttributeId=\"http://security.bea.com/ssmws/ssm-ws-1.0.wsdl#NumberOfBorrowedBooksAttribute\"        DataType=\"http://www.w3.org/2001/XMLSchema#string\" xsi:type=\"ns4:AttributeType\">        <ns4:AttributeValue xsi:type=\"ns4:AttributeValueType\">abc</ns4:AttributeValue>   </ns4:Attribute></ns4:Environment>                  </Request>    </soapenv:Body></soapenv:Envelope>";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new ByteArrayInputStream(soapXML.getBytes()));

        XPathFactory xPathFactory = XPathFactory.newInstance();

        // Create XPath object from XPathFactory
        XPath xpath = xPathFactory.newXPath();

        // Compile the XPath expression for getting all brands
        XPathExpression xPathEnvelopeExpr = xpath.compile("//*[local-name()='Envelope']");
        Object result = xPathEnvelopeExpr.evaluate(doc, XPathConstants.NODESET);
        System.out.println("Java Xpath text example: All brands of popular smartphones " + result);

    }

}