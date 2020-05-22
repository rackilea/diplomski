public static int Class() {
    System.out.println("Character Types");

    Map<String, Integer> data = new HashMap<>();
    data.put("Wizard", 6);   data.put("Sorcerer", 6);   data.put("Monk", 8);
    data.put("Cleric", 8);   data.put("Warlock", 8);    data.put("Druid", 8);
    data.put("Rouge", 8);    data.put("Bard", 8);       data.put("Fighter", 10);
    data.put("Ranger", 10);  data.put("Paladin", 10);   data.put("Barbarian", 12);

    data.keySet().forEach(s -> System.out.println("\t" + s));
    int value = -1;
    String choice;

    do {
        System.out.println("Select a Character name from the given list above");
        choice = sc.nextLine();
    } while ((value = data.getOrDefault(choice, -1)) == -1);

    return value;
}