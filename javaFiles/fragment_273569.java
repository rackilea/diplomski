class MyReader
{
  String[] tokens;

  int tokenIndex = 0;

  public String nextWord()
  {
    if(tokens == null || tokens.length <= tokenIndex)
    {
        // feel free to replace this line with whatever logic you want to
        // use to fill in a new line.
        tokens = readNextLine();
        tokenIndex = 0;
    }
    String retVal = tokens[tokenIndex];
    tokenIndex++;

    return retval;
  }   
}