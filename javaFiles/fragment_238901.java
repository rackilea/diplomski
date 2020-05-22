int countsOf123s = 0;
while (in.hasNextLine())
{
    String[] words = in.nextLine().split(" "); //or for any whitespace do \\s+
    for(String singleWord : words)
    {
        if(singleWord.equals("123"))
        {
            //do something
            countsOf123s++;
        }
    }
}