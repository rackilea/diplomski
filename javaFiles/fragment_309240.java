public boolean retainAll(Collection c) {  
    if(c == null)
    {
        throw new NullPointerException("collection is null");
    }
    Iterator itr = iterator(); // i.e. iterate over this list

    boolean found = false;
    while(itr.hasNext())
    {   
        if(!c.contains(itr.next()))
        {
            itr.remove(); 
            found = true; 
        }
    }

    return found;
}