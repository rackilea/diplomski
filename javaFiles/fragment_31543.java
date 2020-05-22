public static int count(String str, char a, int high) {

    if (str == null || str.length() == 0) {
    // just to be extra safe, if we have an empty string or null 
        return 0;

    }
    //changed this end condition - now high describes how many steps we take before returning the answer
    if (high == 0) // to stop the recursion from infinitely looping
        return high;
    if (str.charAt(str.length() - 1) != a) // if the last character in the string is not equal to "a" subtract from count(substring)
        return count(str.substring(0, str.length() - 1), a, high - 1);
    else 
        return 1 + count(str.substring(0, str.length() - 1), a, high - 1); 
        // else add +1 to count for each instance of "a" in the string

}