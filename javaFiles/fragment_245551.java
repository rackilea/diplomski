public void add(E obj)
{
    int index = calculateArraySlotSomehow(obj);

    listArray[index].add(obj);

    count++;
}