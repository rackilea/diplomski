SAXBuilder builder = new SAXBuilder();
Document document = builder.build(new File("foo.xml"));

XPath xPath = XPath.newInstance("/RootElement/Achild");

/*If you want to find all the "Achild" elements 
and do not know what the document structure is, 
use the following XPath instead(less efficient):
XPath xPath = XPath.newInstance("//Achild");
*/

Element aChild = (Element) xPath.selectSingleNode(document);

if(aChild == null){
  //There is at least one "Achild" element in the document
} else{
  //No "Achild" elements found
}