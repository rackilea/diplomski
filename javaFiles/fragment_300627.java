float[] freq = Bloor_S.freq();
for (int i = 0; i < 26; i++)
{
    System.out.printf("%6.2f", freq[i]);
    System.out.printf("%3c", '|');
    System.out.println();
}