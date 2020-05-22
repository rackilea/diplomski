public void clear() {
    modCount++;

    // Let gc do its work
    for (int i = 0; i < size; i++)
        elementData[i] = null;

    size = 0;
}