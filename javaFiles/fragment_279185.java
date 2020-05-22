public static void main(String args[]) {

    ChainNode firstNode = new ChainNode("a");
    ChainNode newNode = new ChainNode("b", firstNode);
    ChainNode newNode2 = new ChainNode("c", newNode); 

    System.out.println(firstNode.element);
    System.out.println(newNode.element);
}