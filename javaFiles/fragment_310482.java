String[] lines = {"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do",
    "eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut",
    "enim ad minim veniam, quis nostrud exercitation ullamco laboris",
    "nisi ut aliquip ex ea commodo consequat.",
    "",
    "    This must NOT be matched. Because it has 4 whitespaces at the beginning.",
    "",
    "Lorem ipsum dolor sit amet. Ut enim ad minim veniam."};
for (String line : lines) {
    if (!line.startsWith("    ")) {
        String[] words = line.split("[\\p{IsPunctuation}\\p{IsWhite_Space}]+");
        System.out.println("words = " + Arrays.toString(words));
    }
}