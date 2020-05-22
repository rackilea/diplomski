public void add(E element) {

    int index = size++;
    if(size >= elementData.length-1) {

        // it ensures elementData
        elementData = java.util.Arrays.copyOf(elementData, size);
    }
    elementData[index] = element;
}