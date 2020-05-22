//the value you want to insert
int[] toInsert = {someValue, someOtherValue};

//assume theList is the list you're working with
for(int index = 0; index < theList.size() -1; index ++)
{
     int key = theList.get(index)[0];
     int nextKey = theList.get(index + 1)[0];

     //if we've reached the correct location in the list
     if (toInsert[0] > key && toInsert[0] < nextKey)
     {
          //insert the new element right after the last one that was less than it
          theList.add(index + 1,toInsert);
     }
}