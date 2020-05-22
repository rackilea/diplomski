public boolean hasNext() {
        Node tempNode = nextNode;   // nextNode need to stay the same
        while (tempNode != null){
            if (tempNode .data_ % 2 != 0){
                return true;
            }
            tempNode = tempNode._next;
        }
        // if we are here, we found no element that is odd
        return false;
    }