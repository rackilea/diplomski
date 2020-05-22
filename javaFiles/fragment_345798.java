try
{
     if(word.contains(" "))
     {
          throw new WordContainsException();
     }
}
catch(WordContainsException ex)
{
      // Process message however you would like
}