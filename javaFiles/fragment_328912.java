static void barprint(int[] barLength, char[] barSymbols) 
{
    for (int length = 0; length < barLength.length; length++)
    {
        System.out.print(barLength[length]);
    }

    for (int length = 0; length < barSymbols.length; length++)
    {
        System.out.print(barSymbols [length]);
    }
}