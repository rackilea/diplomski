Iterator itr = myList.iterator();

while(itr.hasNext())
{
    Object o = itr.next();

    if(o meets some condition)
    { 
        //YOURE MODIFYING THE LIST
        myList.remove(o);
    }
}