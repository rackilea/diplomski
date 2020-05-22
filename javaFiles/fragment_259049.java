public static void main(String[] args) {
    System.out.println(" Result:"+sillyStringCompare("ABC", "DEF"));
    System.out.println(" Result:"+sillyStringCompare("BIKE", "FGEH"));
    System.out.println(" Result:"+sillyStringCompare("Alex", "BoB"));
    System.out.println(" Result:"+sillyStringCompare("Mom", "DaD"));
}

private static boolean sillyStringCompare(String stringOne, String stringTwo){
    System.out.print('"'+stringOne+'"'+" ---> "+'"'+stringTwo+'"');
    if(stringOne.length()!=stringTwo.length())
        return false;

    if(duplicateLetterInString(stringOne, 0))
        return false;

    if(duplicateLetterInString(stringTwo, 0))
        return false;

    return true;
}

private static boolean duplicateLetterInString(String string, int index) {
    char compareChar = string.charAt(index);

    char[] charArray = string.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
        if (charArray[i] == compareChar && i != index)
            return true;
    }

    return string.length() > index + 1 && duplicateLetterInString(string, ++index);
}