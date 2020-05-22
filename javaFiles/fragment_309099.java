private static String unmangle(String word)
{      
    String newTemp = word.substring(word.indexOf('%')+1);
    char hex = (char)hexToInt(newTemp);

    word=word.replace("%", "");
    word=word.replace("+", " ");
    return word = word.replace(newTemp, "")+ hex;
}