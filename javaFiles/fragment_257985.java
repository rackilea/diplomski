public int add(int position, int value) {

    // Creates a new listEntry 
    DEntry listEntry = new DEntry(value, null, null);
    DEntry temp = header;

    int i = 0;

    if (position < 0 || position > size) {
        return -1;
    }

        while (i <= position) {
            temp = temp.next;
            i++;
        }

    // setting the elements neighbours
    listEntry.next = temp;
    listEntry.previous = temp.previous;

    // placing the new element between last and next
    temp.previous.next = listEntry;
    temp.previous = listEntry;

    // places the new entry in the list
    temp = listEntry;
    size++;

    return 0;
}