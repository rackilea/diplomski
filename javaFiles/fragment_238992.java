public class FirstLetter
{
    public static void main(String[] args)
    {
        System.out.println(firstLetter());
    }

    public static String firstLetter()
    {
        String line = "AD3F" + "EF4G" + "32SFB";

        for (int i = 0; i < line.length(); i++)
        {
            char ch = line.charAt(i);
            if (Character.isLetter(ch))
            {
                System.out.println("This is the first letter: " + ch);
                return Character.toString(ch);
            }

        }
        System.out.println("No character found");
        return "";
    }
}