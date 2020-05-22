public static void main(String [] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a sentence: ");
    String sentence = input.nextLine();
    String[] words = sentence.split(" ");
    for (int i = words.length - 1; i >= 0; i--) {
        System.out.println(words[i]);
    }
}