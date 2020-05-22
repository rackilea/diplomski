public static String reverse(String s)
{
  String rev = " ";
  for (int i=s.length()-1; i>=0; i--)
  rev.append(s.charAt(i); // <--------- This is O(n)
  Return rev.toString();
}