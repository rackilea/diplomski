public static CardType typeOf(String card) {
    for (CardType type : values()) {
        for(String numbers : type.pattern) {
            if(numbers.equals(card)) {
                return type;
            }
        }
    }
    throw new IllegalArgumentException("Type for card pattern " + card + " was not found.");
}