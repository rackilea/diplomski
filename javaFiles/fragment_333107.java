public static String concatenateBackwards(List<String> words)
{
   String str = "";
   ListIterator iter = words.listIterator(list.size());
   while (iter.hasPrevious())
  {
     str += iter.previous();
  }
  return str;  
}