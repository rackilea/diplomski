static String removeDuplicates(String cipher) {
    Set<Character> charSet = new LinkedHashSet<Character>();

    for (char ch : cipher.toCharArray()) {
        charSet.add(ch);
    }

    StringBuilder stringBuilder = new StringBuilder();

    for (char c : charSet) {
        stringBuilder.append(c);
    }

    return stringBuilder.toString();
}