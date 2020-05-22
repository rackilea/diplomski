public String[] shiftRightX(String[] words, String[] data)
{
    for (int x = 0; x < data.length; x++)
    {
        for(int i= words.length - 1; i>0; i--)
        {
            words[i]=words[i-1];
        } 
        words[0] = data[x];
    } 
    return words;  
}