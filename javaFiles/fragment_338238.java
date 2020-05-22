E element = elementData[index]; // get the element to be removed
int numMoved = elementData.length - index - 1;
// move all the elements that follow the moved element
if (numMoved > 0)
    System.arraycopy(elementData, index+1, elementData, index, numMoved);
// put the moved element at the end
elementData[elementData.length - 1] = element;