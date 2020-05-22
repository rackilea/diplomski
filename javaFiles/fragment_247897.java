public String removeDuplicates(String yourText) {
    Set<String> elements = new LinkedHashSet<>(Arrays.asList(yourText.split(";")));

    Iterator<String> it = elements.iterator();

    StringBuilder sb = new StringBuilder(it.hasNext() ? it.next() : "");
    while (it.hasNext()) {
        sb.append(';').append(it.next());
    }

    return sb.toString();
}