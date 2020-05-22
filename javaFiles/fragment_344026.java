listOfTerms = doc.getElementsByTagName("surname");
totalTerms = listOfTerms.getLength();
System.out.println("Total no of terms : " + totalTerms + "\n");
for(int s= 0; s<listOfTerms.getLength() ; s++){
    Node firstTermNode = listOfTerms.item(s);
    if(firstTermNode.getNodeType() == Node.ELEMENT_NODE){
        Element firstTermElement = (Element)firstTermNode;
        System.out.println(firstTermElement.getTextContent());
    }//end of if clause
}//end of for loop with s var