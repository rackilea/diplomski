public void remove(int location)
{
    //remove a digit from LinkedList given by location
    for (int i=0; i<theLists[location].size(); i++){
        theLists[location].remove(i);
        theLists[location].add(i,0);
    }
}