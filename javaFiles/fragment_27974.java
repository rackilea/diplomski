public static boolean surroundedCharacter(char[] letters){
    boolean result = false;
    for(int i = 1; i < letters.length - 1; i++) {
        // You said that if the string is "abccc", should return false.
        // So, we check if the previous or the next letter is different to 
        //the actual value of i
        if((letters[i-1] == letters[i+1]) && (letters[i-1] != letters[i])) {
            result = true;
        }
    }
    return result; 
}