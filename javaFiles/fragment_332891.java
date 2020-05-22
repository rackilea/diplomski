public static String reverseSentence(final String sentence) {
    final Pattern pattern = Pattern.compile("[^A-Za-z']+");
    final List<String> words = pattern.splitAsStream(sentence)
            .map(String::toLowerCase)
            .collect(toList());
    final StringBuilder reversed = new StringBuilder();
    final ListIterator<String> i = words.listIterator(words.size());
    reversed.append(capitalise(i.previous()));
    while (i.hasPrevious()) {
        reversed
                .append(" ")
                .append(i.previous());
    }
    reversed.append(".");
    return reversed.toString();
}