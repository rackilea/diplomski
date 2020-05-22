public class AvXmlParser extends DefaultXMLParser
{

/*
 * (non-Javadoc)
 * @see ca.uhn.hl7v2.parser.DefaultXMLParser#encodeDocument(ca.uhn.hl7v2.model.Message)
 */
public Document encodeDocument(Message source) throws HL7Exception
{
String messageClassName = source.getClass().getName();
String messageName = messageClassName.substring(messageClassName.lastIndexOf('.') + 1);
org.w3c.dom.Document doc = null;
try
{
// doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
    doc = XmlUtilities.emptyDom();
// Element root = doc.createElement(messageName);
    Element root = doc.createElementNS("urn:hl7-org:v2xml",messageName);
    doc.appendChild(root);
}
catch (Exception e)
{
    throw new HL7Exception("Can't create XML document - " + e.getClass().getName(), e);
}
encode(source, doc.getDocumentElement());
return doc;
}

/**
 * @param groupObject
 * @param groupElement
 * @throws HL7Exception
 */
private void encode(ca.uhn.hl7v2.model.Group groupObject, org.w3c.dom.Element groupElement) throws HL7Exception
{
String[] childNames = groupObject.getNames();
String messageName = groupObject.getMessage().getName();
try
{
    for (int i = 0; i < childNames.length; i++)
    {
    Structure[] reps = groupObject.getAll(childNames[i]);
    for (int j = 0; j < reps.length; j++)
    {
        Element childElement = groupElement.getOwnerDocument().createElement(makeGroupElementName(messageName, childNames[i]));
        groupElement.appendChild(childElement);
        if (reps[j] instanceof Group)
        {
        encode((Group) reps[j], childElement);
        }
        else if (reps[j] instanceof Segment)
        {
        encode((Segment) reps[j], childElement);
        }
    }
    }
}
catch (DOMException e)
{
    throw new HL7Exception("Can't encode group " + groupObject.getClass().getName(), e);
}
}

/*
 * (non-Javadoc)
 * @see ca.uhn.hl7v2.parser.XMLParser#parseStringIntoDocument(java.lang.String)
 */
protected synchronized Document parseStringIntoDocument(String message) throws HL7Exception
{
try
{
    Document doc = XmlUtilities.parseString(message);
    return doc;
}
catch (Exception e)
{
    throw new HL7Exception("Exception parsing XML",e);
}
}
}