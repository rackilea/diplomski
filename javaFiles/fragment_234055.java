boolean removeAll(int val)
{
    boolean retVal = false;
    do{
        retVal = removeFirst(val);
    }while(retVal);

    return retVal;
}