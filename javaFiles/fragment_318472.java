String[] allLetters = new String[] {
                "0",
                "1",
                "ABC",
                "DEF",
                "GHI",
                "JKL",
                // etc...
        };

public static void convert(String phoneNumber)
{
  convertSubstring(phoneNumber,"");
}

private static void convertSubstring(String phoneNumber, String convertedLetters)
{                   
  int digit = Integer.parseInt(phoneNumber.substring(0, 1));
  String letters=allLetters[digit];
  String remainingString=phoneNumber.substring(1);

  for (int i = 0; i < letters.length(); ++i) 
  {
     char letter = letters.charAt(i);
     String result=convertedLetters+letter;
     if (remainingString.length()==0)
        System.out.println(result);
     else
        convertSubstring(remainingString, result);
  }
}