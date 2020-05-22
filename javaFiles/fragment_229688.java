bool IsWordPronounceable(string word)
{
    string[] threeLetterBlocks = BreakIntoThreeLetterBlocks(word);
    foreach(string block in threeLetterBlocks)
    {
        if (blockFrequency[block] < THRESHOLD)
            return false;
    }
    return true;
}