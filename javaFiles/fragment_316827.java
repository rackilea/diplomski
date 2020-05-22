class Main
{
public static void main( String args[] )
{
    System.out.print( "#Please enter a word : " );
    String word = BIO.getString();

    while(!word.equals("QUIT")){

        int i, length, vowels = 0;
        String j;
        length = word.length();
        for (i = 0; i < length; i++)
        {

            j = word.substring(i, i + 1);

            if (j.equalsIgnoreCase("a") == true)
                vowels++;
            else if (j.equalsIgnoreCase("e") == true)
                vowels++;
            else if (j.equalsIgnoreCase("i") == true)
                vowels++;
            else if (j.equalsIgnoreCase("o") == true)
                vowels++;
            else if (j.equalsIgnoreCase("u") == true)
                vowels++;
        }
        System.out.print("[  " + vowels + "] vowels in " + "\""+word+"\"");

        System.out.print("\n");

        System.out.print("#Please enter a word : ");
        word = BIO.getString();
    }

}