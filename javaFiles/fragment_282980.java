private static void reduceVocab(HashSet<String> vocab) {
    Set<String> copy = new HashSet<>();
    for (String str : vocab) {
        str = str.replaceAll("[^a-zA-Z0-9]", "");
        if (str.length() > 3)
            copy.add(str);
    }
    vocab.clear();
    vocab.addAll(copy);
}