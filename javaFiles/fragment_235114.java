private static boolean check(String input) {
    IntStream characters = input.codePoints().filter(Character::isLetter);
    return characters
            .distinct()
            .count() == characters.count();
}