StringTokenizer parser = new StringTokenizer(lineToParse, "/");
if (parser.hasMoreTokens()) {
    String q = parser.nextToken();
    if (parser.hasMoreTokens()) {
        String a = parser.nextToken();
        QuizCard card = new QuizCard(q, a);
        cardList.add(card);
    }
}