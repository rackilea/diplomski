Vector<Vector<...>> outerVec = ...
...

Iterator<Vector<...>> outerIterator = outerVec.iterator();
while(outerIterator.hasNext())
{
     Vector<...> innerVec = outerIterator.next();
     // Work with apple, orange, etc
     Iterator<...> innerIterator = innerVec.iterator();
     while(innerIterator.hasNext())
     {
          //work with Apple, Orange, etc.
     }
}