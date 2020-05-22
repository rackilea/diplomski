public class Contains
{

    private static boolean doesContain = false;

    public static void main(String[] args)
    {
        System.out.println(contains("Java programming", "ogr"));
    }

    public static boolean contains(String haystack, String needle)
    {
        if(haystack.length() < needle.length())
        {
            return false;
        }
        else
        {
            for(int i = 0; i < needle.length(); i++)
            {
                if(haystack.charAt(i) != needle.charAt(i))
                    if((i + 1) == needle.length())
                        {
                            doesContain = false;
                            break;
                        }
                    else
                        break;
                else
                    if((i + 1) == needle.length())
                    {
                        doesContain = true;
                        break;
                    }
                    else
                        continue;
            }
            char[] haystackChar = haystack.toCharArray();
            char[] newCharArray = new char[(haystackChar.length - 1)];

            for(int j = 1; j < haystackChar.length; j++)
            {
                newCharArray[j - 1] = haystackChar[j];
            }

            String newStr = new String(newCharArray);

            if(doesContain == false)
                contains(newStr, needle);
        }
        return doesContain;
   }
}