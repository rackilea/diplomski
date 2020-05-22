NodeList nodeList = document.getElementsByTagName(DCDirectProcessorConstants.Tag_Response_getValue);
if(nodeList.getLength() > 0) {
  Node node = nodeList.item( 0 ).getAttributes().getNamedItem(DCDirectProcessorConstants.Tag_Response_Status);
  ...
} else {
  // handle the case no node found
}