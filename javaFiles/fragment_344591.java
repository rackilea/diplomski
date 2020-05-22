public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    ArrayList<String> words = new ArrayList<String>();
    System.out.println("Enter text: ");
    while (sc.hasNextLine()) {
        String userInput = sc.nextLine();
        words.add(userInput);
        String encodedString = Base64.getEncoder().encodeToString(userInput.getBytes());
        System.out.println("User Input encoded: " + encodedString);
        if (userInput.equals("STOP")) {
            break;
        }
    }
    System.out.println(words);
}