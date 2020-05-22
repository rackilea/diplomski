private void rangeCheck(int index) 
{
    if (index >= size) {
         throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
}