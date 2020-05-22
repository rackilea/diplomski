NodeList priorityNumbers = (NodeList) xPath.compile("/priority-claims/priority-claim/document-id/doc-number/text()").evaluate(xmlDocument, XPathConstants.NODESET);
NodeList priorityDates = (NodeList) xPath.compile("/priority-claims/priority-claim/document-id/date/text()").evaluate(xmlDocument,XPathConstants.NODESET);

for(int i=0; i<priorityNumbers.getLength();i++){
    System.out.println(priorityNumbers.item(i).getNodeValue());
}

for(int i=0; i<priorityDates.getLength();i++){
    System.out.println(priorityDates.item(i).getNodeValue());
}