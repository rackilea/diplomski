public static Element translate(XmlObject o)
{
  org.w3c.Document docOld = (org.w3c.dom.Document) o.newDomNode();
  nu.xom.Document docNew = DOMConverter.convert(docOld);
  return docNew.getRootElement();
}