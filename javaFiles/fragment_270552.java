public static String doubleVowel(String str) { 
    StringBuilder result = new StringBuilder();
    for(int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        result.append(ch);
        if (ch == 'a' || 
            ch == 'e' ||
            ch == 'i' || 
            ch == 'o' ||
            ch == 'u') {
            result.append(ch); // second append for vowels
    {
    return result.toString();
}