// remove when the list is empty
if (mFirst == null) {
    return false;
}

// remove at first
if (mFirst.getID() == ID) {
    mFirst = mFirst.getLink();
    return true;
}

PersonNode currentNode = mFirst,getLink();
PersonNode previousNode = mFirst;
while(true) {
    if (currentNode == null) {
        // ID not found
        return false;
    }

    if (currentNode.getID() == ID) {
        previouseNode.setLink(currentNode.getLinke());
        return true;
    }

    currentNode = currentNode.getLink();
}