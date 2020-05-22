ListIterator aItr = aList.listIterator();
while (aItr.hasNext()) {
 int a = aItr.next();
 ListIterator bItr = aList.listIterator(aItr.previousIndex());
 while (bItr.hasNext()) {
   // ...
 }
}