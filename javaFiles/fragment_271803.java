class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        String sentence = "I tried to speak @td Spanish @ty, and my @yd friend tried to @yi speak English @yy.";

        sentence = sentence.replaceAll(" \\@[a-z]+", "");

        System.out.println(sentence);
    }
}