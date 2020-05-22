public static boolean isPalindrome(char[] a, int used) {
    char[] newA = new char[a.length];
    int newNumber = used - 1;
    for (int i = 0; i <= newNumber; i++) {
        newA[i] = a[newNumber - i];
        System.out.println("Your original word was: " + String.valueOf(a));
        System.out.println("Backwards, your word is: " + String.valueOf(newA));
    }
    if (String.valueOf(String.valueOf(newA)).equalsIgnoreCase(String.valueOf(a))) {
        System.out.println("Your word or words are palindromes.");

    } else {
        System.out.println("Your word or words are not palindromes");
    }
    return (String.valueOf(String.valueOf(newA)).equalsIgnoreCase(String.valueOf(a)));
}