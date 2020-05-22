List<String> deck = new ArrayList<>();
deck.add("Ace of Clubs");
deck.add("Two of Clubs");
deck.add("Three of Clubs");

StringJoiner stringJoiner = new StringJoiner("|", "{", "}");
for (String card : deck) {
  stringJoiner.add(card);
}
System.out.println(stringJoiner.toString());