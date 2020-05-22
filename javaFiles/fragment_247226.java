@SuppressWarnings("unchecked")
E elementData(int index) {
    return (E) elementData[index];
}


/**
 * Returns the element at the specified position in this list.
 *
 * @param  index index of the element to return
 * @return the element at the specified position in this list
 * @throws IndexOutOfBoundsException {@inheritDoc}
 */
public E get(int index) {
    rangeCheck(index);


    return elementData(index);
}