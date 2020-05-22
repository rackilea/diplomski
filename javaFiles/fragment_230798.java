public boolean allKnown(ArrayList<String> wordList)
{
    boolean result = true;
    for(int index = 0; index < wordList.size() && result; index++)
    {
        if(!words.contains(wordList.get(index)))
        {
            result = false;
        }
    }
    return result;
}