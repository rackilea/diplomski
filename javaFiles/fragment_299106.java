public Map<String, Integer> ngram(String inp, Integer n)
{
    Map<String, Integer> nGram = new HashMap<>();
    for(int i = 0; i < inp.length() - n - 1; i++)
    {
        String item = inp.substring(i, i+n);
        int itemCount = nGram.getOrDefault(item, 0);
        nGram.put(item, itemCount+1);
    }
    return nGram;
}