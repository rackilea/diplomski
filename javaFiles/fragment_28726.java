public void addElement(String first, String last, long number) {
        Element previousNode, newNode, currentNode;

        newNode = new Element(first, last, number);

        if (this.firstNode == null) // Determine if there is a firstNode
        {
            this.firstNode = newNode;      // Store the first node
            this.lastNode = newNode;       // ... and the last node
        } else {
            this.lastNode.nextElement = newNode;
            newNode.previousElement = this.lastNode;
            this.lastNode = newNode;
        }
    }