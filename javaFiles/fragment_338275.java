public static String reverseName (String name) {

    name = name.trim();

    StringBuilder reversedNameBuilder = new StringBuilder();
    StringBuilder subNameBuilder = new StringBuilder();

    for (int i = 0; i < name.length(); i++) {

        char currentChar = name.charAt(i);

        if (currentChar != ' ' && currentChar != '-') {
            subNameBuilder.append(currentChar);
        } else {
            reversedNameBuilder.insert(0, currentChar + subNameBuilder.toString());
            subNameBuilder.setLength(0);
        }

    }

    return reversedNameBuilder.insert(0, subNameBuilder.toString()).toString();

}