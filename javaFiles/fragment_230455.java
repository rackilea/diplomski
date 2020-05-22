@Override
public Object push(Object newElement) {
     first = new Node(newElement, first);
     elementCount++;
     return newElement;
}