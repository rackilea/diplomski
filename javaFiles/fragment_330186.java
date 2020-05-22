public static int Class() {
    System.out.println("Character Types");

    List<String> chaName = Arrays.asList("Wizard", "Sorcerer", "Monk", "Cleric", "Warlock",
            "Druid", "Rouge", "Bard", "Fighter", "Ranger", "Paladin", "Barbarian");
    int[] characterDiceValue = new int[]{6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 12};

    chaName.forEach(s -> System.out.println("\t" + s));
    int index = -1;
    String characterClass;

    do {
        System.out.println("Select a Character name from the given list above");
        characterClass = sc.nextLine();
    } while ((index = chaName.indexOf(characterClass)) == -1);

    return characterDiceValue[index];

}