private static String reverse(String string) {
    if(string.length() == 1)
        return string + string + string;

    else 
        return reverse(string.substring(1)) + string.charAt(0) + string.charAt(0) + string.charAt(0);
}