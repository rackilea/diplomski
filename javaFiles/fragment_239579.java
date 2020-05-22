public SLL mergeUnsorted(SLL otherList)
{
    if (otherList != null && otherList.first != null) {
        SLLNode last = null;
        Iterator itr = iterator() ;
        for (itr.hasNext())
        {
            Object elem  = itr.next() ;
            if (elem.succ == null) {
                last = elem;
            }
        }
        if (last != null) {
            last.succ = otherList.first;
        }
    }    
    return this;
}