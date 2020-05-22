NamedNodeMap attributes = fstElmnt.getAttributes();

for (int a = 0; a < attributes.getLength(); a++) 
{
        Node theAttribute = attributes.item(a);
        System.out.println(theAttribute.getNodeName() + "=" + theAttribute.getNodeValue());
}