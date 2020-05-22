PersonNode newNode = new PersonNode(ID, name);
PersonNode currentNode = mFirst;

for(; currentNode.getLink().getID() < ID; currentNode = currentNode.getLink());
newNode.setLink(currentNode.getLink());
currentNode.setLink(newNode);