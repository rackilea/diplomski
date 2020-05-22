final LinkedList<CustomElement> newList = new LinkedList<> ();

for (final CustomElement e: myList)
{
  if (e matches your pattern) { newList.addFirst (e); }
  else { newList.addLast (e); }
}

myList = newList;