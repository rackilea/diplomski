PersonNode newNode = new PersonNode(ID, name);
PersonNode currentNode = mFirst;

// insert when list is empty
if (mFirst == null) {
    mFirst = newNode;
    return true;
}

if (mFirst.getID() > ID) {
    // insert at front
    newNode.setLink(mFirst);
    mFirst = newNode;
}

while(true) {
    if (currentNode.getID() == ID) {
        // ID exists
        return false;
    }

    PersonNode nextNode = currentNode.getLink();
    if (nextNode == null) {
        // insert at last
        currentNode.setLink(newNode);
        return true;
    }
    if (nextNode.getID() > ID) {
        // insert at mid
        newNode.setLink(nextNode);
        currentNode.setLink(newNode);
        return true;
    }

    currentNode = nextNode;
}