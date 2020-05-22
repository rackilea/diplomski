public void insertInfo(String name, String rfidTag, String initPosition, double price){

    ItemInfo obj = new ItemInfo(name, rfidTag, initPosition, initPosition, price);
    ItemInfoNode addition = new ItemInfoNode();
    addition.setInfo(obj);
    ++listCount;

    // Walk to the item following:
    ItemInfoNode insertionNext = head;
    while (insertionNext != null
            && insertionNext.getInfo().getTag().compareTo(rfidTag) >= 0) {
        insertionNext = insertionNext.next;
    }

    ItemInfoNode insertionPrevious = insertionNext == null ? tail
        : insertionNext.previous;

    // Prepare addition itself:
    addition.next = insertionNext;
    addition.previous = insertionPrevious;

    // The next link backwards should point to the addition:
    if (insertionNext == null) {
        tail = addition;
    } else {
        insertionNext.previous = addition;
    }

    // The previous link forwards should point to the addition:
    if (insertPrevious == null) {
        head = addition;
    } else {
        insertPrevious.next = addition;
    }
}