Collections.sort(player1, new Comparator<Card>() {

        @Override
        public int compare(Card c1, Card c2) {
            Integer a = c1.getFaceValue();
            Integer b = c2.getFaceValue();
            return a.compareTo(b); // for descending order use b.compareTo(a)
        }
    });