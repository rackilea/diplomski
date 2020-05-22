ItemType PointerArray::getNextItem()
{
    ItemType item;
    if (currentPos == NULL)
    {
        currentPos = listData;
    }
    else
    {
        currentPos = currentPos->next;
    }
    item = currentPos->info;
    return item;
}