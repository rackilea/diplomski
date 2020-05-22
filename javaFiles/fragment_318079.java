public static int countWords(String str)
{
  int count = 1, num_of_letters = 0, final_count=1;

  for (int i=0;i<=str.length()-1;i++)
  {
    //This line
    if (str.charAt(i) == ' ' && str.charAt(i+1)!=' ')