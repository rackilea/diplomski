public static void main(String[] args) {
    //get the nodeList
    //...
    for (int h = 0; h < nodeLista.getLength(); h++) {
        Node Primer_Hijo = nodeLista.item(h); 
        navegate(Primer_Hijo);
    }

    //or (better) the root node
    navegate(rootNode);
}

void navegate(Node node){
    //do something with node
    node.getAttributes();
    //...

    for(int i=0; i<node.getChildNodes().getLength(); i++)
        navegate(node.getChildNodes().item(i));
    }
}