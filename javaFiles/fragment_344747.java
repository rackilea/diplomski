LLIntegerNode candidate = new LLIntegerNode();
for(int j =9999; j >=1000; j--){ 
    LLIntegerNode element = new LLIntegerNode(j, null); //new node
    candidate.setLink(element);
    candidate = element;
}