@Override
public int compare(String s1, String s2)
{
   int i;
   int length = s1.length() + s2.length();
   for (i = 0; i < length; i++)
   {
      char c1 = get(s1, s2, i),
           c2 = get(s2, s1, i);
      if (c1 != c2)
      {
         return (c1 > c2 ? -1 : 1);
      }
   }
   return 0;
}

private char get(String s1, String s2, int index)
{
   if (index < s1.length())
      return s1.charAt(index);
   else
      return s2.charAt(index - s1.length());
}