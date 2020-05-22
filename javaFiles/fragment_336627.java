void queryData()
{
    int masterIndex = getMasterIndex();
    if (masterIndex == -1) 
        return;
    byte[] pageData = getMasterPage(masterIndex);
    if (pageData == null)
        return;
    Item1 i1 = getItem1(pageData);
    Item2 i2 = getItem2(pageData);
    if (i1 == null || i2 == null)
        return;
    showResults(i1, i2);
}