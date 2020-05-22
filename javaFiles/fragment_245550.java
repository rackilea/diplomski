private int calculateArraySlotSomehow(E obj)
{
    // 'count' is the total number of elements that are already
    //         stored in this data structure
    // 'size' is the number of array elements
    // 'limit' is the number of elements per list

    int slot = count / limit;

    if (slot >= size) {
        throw new IndexOutOfBoundsException("Index: " + slot + ", Size: " + size);
    }

    return slot;
}