public static void main(String[] args)
{
    String input = "abbac";

    char[] strArr= input.toCharArray();

  String result = "";

  // Reverse
  for(int i = strArr.length -1; i>=0; i--){
      result = result + strArr[i];

  }
  result = removeDuplicate(result.toCharArray());
  System.out.println(new String(result));
}

 // Collapsing any adjacent duplicate characters
public static String removeDuplicate(char[] chars)
{
    char prev = '\0';
    int x = 0;

    for (int i = 0; i < chars.length; i++)
    {
        if (prev != chars[i]) {
            chars[x++] = chars[i];
            prev = chars[i];
        }
    }

    return new String(chars).substring(0, x);
}