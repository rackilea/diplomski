private static boolean charsOK(String s) { 
    String charactersIdontWant = "^àáâãäåçèéêëìíîïðòóôõöùúûüýÿ!&{}¿?.<>~\\()";
    for (char c : charactersIdontWant.toCharArray()) {
        if (s.indexOf(c) != -1) return false;
    }
    return true;

}
public static void main(String[] args) {
    String myString = "thisMayContïain/anything@";
    String myString2 = "thisMayContain/anything@";
    System.out.println(charsOK(myString));
    System.out.println(charsOK(myString2));
}