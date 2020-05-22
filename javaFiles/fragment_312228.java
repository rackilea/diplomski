NodeList itemCheckedNodeList = positionElement.getElementsByTagName("remark");
Element itemCheckedElement = (Element) itemCheckedNodeList.item(0);
NodeList itemCheckedLN = itemCheckedElement.getChildNodes();
Text itemCheckedText = (Text) itemCheckedLN.item(0);
if (itemCheckedText == null) {
    Document doc = itemCheckedElement.getOwnerDocument();
    itemCheckedText = doc.createTextNode("remark");
    itemCheckedElement.appendChild(itemCheckedText);
}
itemCheckedText.setTextContent("Here is a new comment");