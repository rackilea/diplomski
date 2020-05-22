public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter phrase: ");
    String phrase = br.readLine();
    int lth = phrase.length();
    int ctr = 0;
    for (int i = 0; i <= lth - 1; i++) {
        char ch = phrase.charAt(i);
        // Skip this character if it's not a letter
        if (!Character.isLetter(ch)) {
            continue;
        }

        if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u' &&
            ch != 'A' && ch != 'E' && ch != 'I' && ch != 'O' && ch != 'U' ) {
            ctr++;
        }
    }
    System.out.println("No. of consonents: " + ctr);
}