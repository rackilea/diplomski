List<String> words = new ArrayList<>();
try (Scanner sc = new Scanner(new File(path))) {
    //Everything that's not a character is treated as delimiter
    sc.useDelimiter("[^a-zA-Z]+");
    while (sc.hasNext()) {
        words.add(sc.next());
    }
}