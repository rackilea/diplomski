Element marksElm = (Element)eElement.getElementsByTagName("marks").item(0);
String marks = marksElm.getAttribute("isNull");
if (marks.equals("")) {
    marks = marksElm.getTextContent();
}
System.out.println("Marks : " + marks);