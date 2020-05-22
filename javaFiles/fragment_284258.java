for (int i = 0, size = allWords.size(); i < size; i++)
{
    String word = allWords.get(i);

    // add the word if it is not in distinctWords
    if (!distinctWords.contains(word))
    {
        distinctWords.add(word);
    }
 }