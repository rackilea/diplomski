public int removeWordsWithXChars(int size)
{

    Iterator<String> iterator = words.iterator();
    while(iterator.hasNext())
    {
        String word = iterator.next();
        if(word.length() == size)
        {
            iterator.remove(word);
        }
    }
    return 0;
}