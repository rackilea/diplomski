public static int count(String str, char a)
{

  if(str.length() == 0) // here we have to stop the recursion as the string is empty!
      return 0;
  if (str.charAt(str.length() - 1) != a)
      return count(str.substring(0, str.length() - 1), a); // here we send the string - the last character which has been already checked.
  else
      return 1 + count(str.substring(0, str.length() - 1), a);
}