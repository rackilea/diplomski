Collections.sort(listA);
Collections.sort(listB);

ListIterator<String> aIter = listA.listIterator();
ListIterator<String> bIter = listB.listIterator();
List<String> listC = new List<String>();

while(aIter.hasNext() || bIter.hasNext())
{
   if(!bIter.hasNext())
      listC.add(aIter.next());
   else if(!aIter.hasNext())
      listC.add(bIter.next());
   else
   {
      //kinda smells from a C# background to mix the List and its Iterator, 
      //but this avoids "backtracking" the Iterators when their value isn't selected.
      String a = listA[aIter.nextIndex()];
      String b = listB[bIter.nextIndex()];

      if(a==b) 
      {
         listC.add(aIter.next());
         listC.add(bIter.next());
      }
      else if(a.CompareTo(b) < 0)
         listC.add(aIter.next());
      else
         listC.add(bIter.next());          
   }
}