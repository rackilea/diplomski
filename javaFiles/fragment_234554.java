public class FourLetterInCommon 
{
    static String wrd = "SPLIT";
    static String[] d = new String[] { "SPLITS", "SPLITTED", "SPLITTER", "SPLITTERS", "SPLITTING", "SPLITTINGS",
            "SPLITTISM", "SPLITTISMS", "SPLITTIST", "SPLITTISTS" };

    public static void main(String[] args)
    {
        System.out.println(fourletters(wrd, d));
    }

    public static List<String> fourletters(String word, String[] dict)
    {
        int dictsize = dict.length;
        int wordlength = word.length();

        List<String> Commonletters = new ArrayList<String>();

        for (int i = 0; i < dictsize; i++)
        {
            for (int j = 0; j <= wordlength - 4; j++)
            {
                if (dict[i].contains(word.substring(j, j + 4)))
                {
                    Commonletters.add(dict[i]);
                    break;
                }
            }
        }
        return Commonletters;
    }
}