public static String concatenateBackwards(List<String> words)
{
   ListIterator iter = list.listIterator(list.size());
   while (iter.hasPrevious())
  {
     String str = iter.previous() + str; 
  }
  return str;  
}