int pos = 0;
for(int i=0; i<nl2.getLength();i++){
    Node n = nl2.item(i);
    if (n.getNodeType() == Node.ELEMENT_NODE)
    {
        pos++;
        String text=n.getTextContent();
        System.out.println(pos + text);
    }
}