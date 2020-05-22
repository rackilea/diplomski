public static void main(String args[]) {
    String pal = "abc";
    check(pal); // Nested methods are not allowed, thus calling the check
                // method, which is now placed outside main
}

public static void check(String pal) {
    if (pal == null) {
        System.out.println("Null Value..Exit");
    } else {
        StringBuilder str = new StringBuilder(pal);

        // I think I confused you by doing the below.
        // str = str.reverse(); // commenting this

        str.reverse(); // adding this 
        // str.reverse(); reverse will affect the str object. I just assigned it back to make it easier for you
        // That's why if you add a SOP with str.reverse, it'll reverse the string again, which will give the original string back
        // Original string will always be equal to itself. that's why your if will always be true
        // give a SOP with str.toString, not reverse.

        // str.toString is used because str is a StringBuilder object and not a String object.
        if (pal.equals(str.toString())) { // if the string and its reverse are equal, then its a palindrome
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
    }
}