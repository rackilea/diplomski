private void remove( int index)
{
    if(index >= 0)
    {
        E last = elementData[size - 1];
        elementData[index] = last;
        elementData[--size] = null;
    }
}