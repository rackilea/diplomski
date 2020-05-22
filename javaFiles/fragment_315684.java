public static void main(String[] args) {
    String first = "a";

    tryToChangeReference(a);

    // The value of 'first' is still "a"
    // In fact, if the value of 'first' was changed by 
    //    the tryToChangeReference method, then you 
    //    know that the language passes by reference
    System.out.println(a); //outputs: a
}

private static void tryToChangeReference(String a) {
    a = "b";
}