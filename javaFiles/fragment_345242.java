public static void writeDomToXmlStreamWriter(Node node, XMLStreamWriter xmlw) throws XMLStreamException
{
    if (node != null)
    {
        switch (node.getNodeType())
        {
            case Node.ELEMENT_NODE:
            {
                Element element = (Element)node;
                if (element.getPrefix() != null)
                    xmlw.writeStartElement(element.getPrefix(), element.getLocalName(), element.getNamespaceURI());
                else if (element.getNamespaceURI() != null)
                    xmlw.writeStartElement(element.getNamespaceURI(), element.getLocalName());
                else if (element.getLocalName() != null)
                    xmlw.writeStartElement(element.getLocalName());
                else
                    xmlw.writeStartElement(element.getNodeName());
                writeDomAttributesToXmlStreamWriter(element, xmlw);
                for (Node child = element.getFirstChild(); child != null; child = child.getNextSibling())
                    writeDomToXmlStreamWriter(child, xmlw);
                xmlw.writeEndElement();
            }
            break;
            case Node.TEXT_NODE:
            {
                xmlw.writeCharacters(node.getTextContent());
            }
        }
    }
}

private static void writeDomAttributesToXmlStreamWriter(Element element, XMLStreamWriter xmlw) throws XMLStreamException 
{
    NamedNodeMap map = element.getAttributes();
    for (int L = map.getLength(), i = 0; i < L; ++i)
    {
        Node attr = map.item(i);
        if (attr.getPrefix() != null)
            xmlw.writeAttribute(attr.getPrefix(), attr.getLocalName(), attr.getNamespaceURI(), attr.getNodeValue());
        else if (attr.getNamespaceURI() != null)
            xmlw.writeAttribute(attr.getNamespaceURI(), attr.getLocalName(), attr.getNodeValue());
        else if (attr.getLocalName() != null)
            xmlw.writeAttribute(attr.getLocalName(), attr.getNodeValue());
        else 
            xmlw.writeAttribute(attr.getNodeName(), attr.getNodeValue());
    }       
}