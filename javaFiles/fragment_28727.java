public void removeElement(Element node) {
    if (node.nextElement == null) {
        // node is the last node
        this.lastNode = node.previousElement;
        if (this.lastNode != null) {
            this.lastNode.nextElement = null;
        }
    } else {
        node.nextElement.previousElement = node.previousElement;
    }
    if (node.previousElement == null) {
        // node is the first node
        this.firstNode = node.nextElement;
        if (this.firstNode != null) {
            this.firstNode.previousElement = null;
        }
    } else {
        node.previousElement.nextElement = node.nextElement;
    }
}