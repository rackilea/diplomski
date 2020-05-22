public E remove(int index) {
    rangeCheck(index);

    modCount++;
    E oldValue = elementData(index); // ArrayIndexOutOfBoundsException is thrown here

    int numMoved = size - index - 1;
    if (numMoved > 0)
        System.arraycopy(elementData, index+1, elementData, index,
                         numMoved);
    elementData[--size] = null; // clear to let GC do its work

    return oldValue;
}