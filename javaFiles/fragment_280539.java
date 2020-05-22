static final Scanner in = new Scanner(System.in);
static List<String> words = getStandardWords();

public static void main(String[] args) {
    while (true) {
        System.out.println("-- Hangman --");
        System.out.println("1. 1 Player");
        System.out.println("2. 2 Player");
        System.out.println("3. Add word");
        System.out.println("4. Quit");
        System.out.print("Choice : ");
        String choice = in.nextLine();

        switch (choice) {
            case "1":
                //todo
                break;
            case "2":
                //todo
                break;
            case "3":
                addWord();
                break;
            case "4":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice: " + choice);
                break;
        }
    }
}

static List<String> getStandardWords() {
    List<String> result = new ArrayList<>();
    result.add("fish");
    result.add("chicken");
    result.add("icecream");
    return result;
}

static void addWord() {
    System.out.println("Input the word to be added: ");
    String word = in.nextLine();

    // add word
    if (words.contains(word)) {
        System.out.println("Already Added");
    } else {
        words.add(word);
        System.out.println("Succeed!");
    }

    // add more words?
    while (true) {
        System.out.println("Want to add more words?");
        String choice = in.nextLine();

        switch (choice.toLowerCase(Locale.ROOT)) {
            case "n":
            case "no":
                System.out.println("Thanks for adding");
                // print all words
                for (int i = 0; i < words.size(); i++) {
                    System.out.println(words.get(i));
                }
                return;
            case "y":
            case "yes":
                addWord();
                return;
            default:
                System.out.println("Invalid coice: " + choice);
                break;
        }
    }
}