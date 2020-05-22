public static String swap (String entry){

    char[] characters = entry.toCharArray();

    if (entry.length() < 6){
        return null; // cannot swap if length is under 6!
    }

    char tempchar;

    tempchar = characters[0];
    characters[0] = characters[characters.length-1];
    characters[characters.length-1] = tempchar;

    tempchar = characters[1];
    characters[1] = characters[characters.length-2];
    characters[characters.length-2] = tempchar;

    tempchar = characters[2];
    characters[2] = characters[characters.length-3];
    characters[characters.length-3] = tempchar;

    return String.copyValueOf(characters);
}