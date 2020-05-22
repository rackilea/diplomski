public String getResponse(String value)
{
    String X = longestWord(value);  //Your longestWord should also not be static.
    this.responseCount++;        

    if (value.contains("you"))
    {
        ...