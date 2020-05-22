public void add(E element) {

    if(size < elementData.length-1) {

        elementData[size++] = element;
    }
    // TODO else notice of the unsuccessfull add
}