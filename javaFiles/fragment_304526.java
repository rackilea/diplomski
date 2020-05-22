public static List<String> removedText(List<String> s) {
    Iterator<String> text = s.iterator();

    while (text.hasNext()) {
        String token = text.next();
        if (hs.contains(token)) {
            text.remove();
        }
    }
    return s;
}