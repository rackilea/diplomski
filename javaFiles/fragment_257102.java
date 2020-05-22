public int prefixCount(String prefix)
{
    int count = 0;
    TrieNode node = searchPrefix(prefix);
    if(node.isEnd())
    {
        count++;
    }

    for(int index = 0;index < 26;index++)
    {
        char value = (char) (index + 'a');
        TrieNode next = node.get(value);
        if(next != null)
        {
            count += prefixCount(prefix + value);
        }
    }
    return count;
}