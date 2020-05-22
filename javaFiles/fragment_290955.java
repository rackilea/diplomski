while (in.hasNextLine())
{
    char[] line = in.nextLine().toCharArray();
    for (char c : line)
        charFreqs[c]++;
}