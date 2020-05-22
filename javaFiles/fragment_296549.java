public void addAfterNth(Object data,Object o, int n) { 
    Node curr = firstNode;
    while (curr != null) { 
        if (curr.data.equals(o)) n--;
        if (n == 0) { 
            Node newNode = new Node(data,curr.nextNode);
            curr.setNext(newNode);
            break;
        }
        curr = curr.getNextNode();
    }
}