// Where the characters are stored
private ArrayList<String> characters;

public void initDeck() {
    if (characters == null)
        characters = new ArrayList<String>();
    // Extract the numbers if you actually need them, otherwise, they just are constants
    addCharacter("Demoniac", 1, characters);
    addCharacter("Guard", 1, characters);
    addCharacter("Medium", 1, characters);
    addCharacter("Mythomaniac", 1, characters);
    addCharacter("Owl", 1, characters);
    addCharacter("Werehamster", 1, characters);
    addCharacter("Villager", 5, characters);
    addCharacter("Masons", 1, characters);
}

public void addCharacter(String name, int amount, ArrayList<String> cards) {
    if (amount < 0) {
        throw new IllegalArgumentException("Must add a non-negative number of characters for " + name);
    }

    // Don't use '==' for Strings
    if (name.equals("Villager")) {
        if (amount != 5 || amount != 12) {
            throw new IllegalArgumentException("There can only be 5 or 12 " + name);
        }
    }

    for (int i = 0; i < amount; i++) {
        cards.add(name);
    }
}

public int searchCharacters(String character, ArrayList<String> cards) {
    return cards.indexOf(character);
}

public Map<String, Integer> getAllCharacterPositions() {
    Map<String, Integer> allPositions = new LinkedHashMap<String, Integer>();
    for (int i = 0; i < characters.size(); i++) {
        allPositions.put(characters.get(i), i);
    }
    return allPositions;
}

void run() {
    // initialize the characters
    initDeck();

    // shuffle them
    Collections.shuffle(characters);

    // print them all out
    for (int i = 0; i < characters.size(); i++) {
        System.out.printf("%d: %s\n", i, characters.get(i));
    }

    // Find the position of a character
    System.out.println();
    String findCharacter = "Owl";
    // Option 1 -- always linear search lookup
    System.out.printf("%d: %s\n", searchCharacters(findCharacter, characters), findCharacter);
    // Option 2 -- one-time linear scan, constant lookup
    Map<String, Integer> positions = getAllCharacterPositions();
    System.out.printf("%d: %s\n", positions.get(findCharacter), findCharacter);

    // Get a random character
    System.out.println();
    Random rand = new Random(System.currentTimeMillis());
    int randPos = rand.nextInt(characters.size());
    System.out.printf("%d: %s\n", randPos, characters.get(randPos));

    // randomButton.setText(characters.get(randPos));
}