public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Enter a word: ");
    String word = in.next();        
    char F;

    for (int i = 0; i < word.length(); i++) {
        F = word.charAt(i);
        if (F == 'a') {
            System.out.println(i);
        }
    }
}