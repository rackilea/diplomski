public static String hej(String input)
{
    int i;
    for(i = 0; i < input.length(); i++)
        if(input.charAt(i) != '0')
            break;
    return input.substring(i);
}