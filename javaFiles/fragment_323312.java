public static void main(String[] args) {
    // the user is asked to enter a sentence
    Scanner input = new Scanner(System.in);

    System.out.println("enter a sentence");
    String text = input.nextLine();

    // the sentence is split
    String[] splittedSentence = text.split("[[\\s+]*|[,]*|[\\.]]");

    List<String> words = Arrays.asList(splittedSentence); // the word are stored into a variable then added into the array

    System.out.println("enter a word");
    String word = input.next();

    // check if the word is in the list
    if (words.contains(word)) {
        System.out.println("the word is found in the sentence");
    } else {
        System.out.println("the word is not found in the sentence");
    }
}