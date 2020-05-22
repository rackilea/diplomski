public static char oneLeft (char s)
{
    // note the wrap-around chars ('p', 'l', 'm')
    final String keyboard = "pqwertyuioplasdfghjklmzxcvbnm"; 

    // use lastIndexOf to not conflict with wrap-around chars
    int index = keyboard.lastIndexOf(s); 

    return (index > 0) ? keyboard.charAt(index - 1) : s;
}