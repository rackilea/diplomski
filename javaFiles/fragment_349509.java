public static boolean containsUnordered(String input, String searchFor){
    char[] characters = searchFor.toCharArray();
    for (char c: characters)
        if (!input.contains(String.valueOf(c)))
            return false;
    return true;
}