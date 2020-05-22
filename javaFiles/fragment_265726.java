Node item = l.getHeadNode();

while( item != null ) {
    // copy the item
    a.insertLast( item );
    item = item.getNext();
}