public E set(int index, E element) 
{
     rangeCheck(index);  
     E oldValue = elementData(index);
     elementData[index] = element;
     return oldValue;
}