public static String reverse(String string) {
    int index = 0;
    if(string == null){
        return " ";
    }
    /* This will always be true because index is always zero */
    else if(index < string.length()) {
        char a;
        /* This gets the character at position zero */
        a = string.charAt(index);
        /* This increments zero by 1 */
        index += 1;
        /* This takes the character and then calls reverse again (the recursion.
           The problem is that you are passing the full string in and so every time
           you recurse, index will be zero again and the string will be exactly the same length.
           So no exit criterion will ever be triggered. 
           As such this is an infinite recursion. */
        return a + reverse(string);
    }
    return " ";
}