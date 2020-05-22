NodeList baseElmntLst_gold  = goldAnalysis.getElementsByTagName("base");
Element baseElmnt_gold = (Element) baseElmntLst_gold.item(0);

NamedNodeMap baseElmnt_gold_attr = baseElmnt_gold.getAttributes();
for (int i = 0; i < baseElmnt_gold_attr.getLength(); ++i)
{
    Node attr = baseElmnt_gold_attr.item(i);
    System.out.println(attr.getNodeName() + " = \"" + attr.getNodeValue() + "\"");
}

NodeList innerElmntLst_gold = baseElmnt_gold.getChildNodes();
Element innerElement_gold = null;
for (int i = 0; i < innerElmntLst_gold.getLength(); ++i)
{
    if (innerElmntLst_gold.item(i) instanceof Element)
    {
        innerElement_gold = (Element) innerElmntLst_gold.item(i);
        break; // just get first child
    }
}

NamedNodeMap innerElmnt_gold_attr = innerElement_gold.getAttributes();
for (int i = 0; i < innerElmnt_gold_attr.getLength(); ++i)
{
    Node attr = innerElmnt_gold_attr.item(i);
    System.out.println(attr.getNodeName() + " = \"" + attr.getNodeValue() + "\"");
}