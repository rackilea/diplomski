public static void convertCase(String str) {
    convertCase(str, 0, str.length()-1);
}

private static void convertCase(String input, int start, int end) {
    if (input == null || start > end) {
        return;
    }
    char character = input.charAt(start); 
    int ascii = (int) character;
    if (ascii >= 97 && ascii <= 122) {
        character = (char)(ascii-32);
    }
    System.out.print(character);        
    convertCase(input, start+1, end);
}

public static void main(String args[]) throws Exception {
    convertCase("all lowercase HERE");
}