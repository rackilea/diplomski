String nodeName = currentNode.getNodeName()
String nodeValue = currentNode.getNodeValue() ;
if( nodeName.equals("Message")){
     message = nodeValue ;
} else if( nodeName.equals("FrameHeight") {
     frameHeight = nodeValue ;
}