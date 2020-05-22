static boolean isInLanguage(String aString){
    Stack<Character> aStack = new Stack<>(); 

    int i = 0;
    char ch;

    // This is simplified way to write your first while loop
    // Read a character, move the index further, and test, all in single statement
    while ((ch = aString.charAt(i++)) != '$') {
        aStack.push(ch);
    }

    // Iterate till the stack is not empty
    while (!aStack.isEmpty()) {
       // Get next character in string, and pop an element from stack
       // If they are not equal, return false
        if (aString.charAt(i++) != aStack.pop()) {
            return false;
        }
    }

    // If we reach here, means stack is empty. Test if the index `i` has reached end of the string.
    // If it reached the end of the string, return true, else return false (because there are still some characters to be processed).
    return i == aString.length();
}