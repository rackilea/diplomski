ArrayList<Character> alphabet = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D'));
Random random = new Random();
String guess = "";

while (true) {
    /* init a guess */
    guess = "";
    for (int j = 0; j < 4; j++)
        guess += alphabet.get(random.nextInt(alphabet.size()));
    System.out.println("The guess is: " + guess);

    /* remove letters */
    for (int j = 0; j < guess.length(); j++)
        alphabet.remove(new Character(guess.charAt(j)));

    /* the alphabet is empty */
    if (alphabet.isEmpty()) {
        System.out.println("The alphabet is empty");
        break;
    }
}