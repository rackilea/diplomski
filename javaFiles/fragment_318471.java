public class StringRef
{
   public string val;
}

public static void ChangeString(string word)
{
  word = "TWO";
}

public static void SeedCounter(StringRef strRefWord)
{
  strRefWord.val = "TWO";
}