public Node copy() {

        Node currentNode= this;
        Node firstDuplicate = new Node(currentNode.getItem()); //save reference for first node to return
        Node currentDuplicate=firstDuplicate;

        while(Node.NIL!=currentNode.getNext()){
            Node nextNode = currentNode.getNext();
            Node nextCopy = new Node(nextNode.getItem()); //create copy of next
            currentDuplicate.next = nextCopy; //assign this copy as next for current duplicated node
            currentDuplicate = nextCopy; //change reference for current duplicated node to copy 
            currentNode = nextNode; 
        }

        return firstDuplicate;
    }