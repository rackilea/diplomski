public static String[] simpleWords(String[] data) {
    List<String> list = new ArrayList<>();
    for (String word : data) {
        if (!isCompound(data, word)) {
            list.add(word);
        }
    }
    return list.toArray(new String[list.size()]);
}

public static boolean isCompound(String[] data, String word) {
    return isCompound(data, word, 0);
}

public static boolean isCompound(String[] data, String word, int iteration) {
    if (data == null || word == null || word.trim().isEmpty()) {
        return false;
    }
    for (String str : data) {
        if (str.equals(word) && iteration > 0) {
            return true;
        }
        if (word.startsWith(str)) {
            String subword = word.substring(str.length());
            if (isCompound(data, subword, iteration + 1)) {
                return true;
            }
        }
    }
    return false;
}