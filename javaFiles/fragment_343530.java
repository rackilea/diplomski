public static void main(String[] args) {
    ... // skipped previous lines
    // No need to use class name as main is static and method1 is also static.
    String method = method1(word, number); // Call the method with 2 parameters
    System.out.println(method);
}

// With an else - improves readability
public static String method1(String word, int number) {
    if (number == 0) { // If it is zero, return a blank string
        return ""; // return a blank string and not 0(int)
    } else {
        return word + method1(word, number - 1); // method1 requires 2 parameters
    }
}

// Without an else - unnecessary else removed
public static String method1(String word, int number) {
    if (number == 0) { // If it is zero, return a blank string
        return ""; // return a blank string and not 0(int)
    }
    // Removed the else as its really not necessary
    return word + method1(word, number - 1); // method1 requires 2 parameters
}