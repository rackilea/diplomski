for (int i = 0; i < cards.length; i++) {
    switch (cards[i].toUpperCase()) {
        case "1C":
            cards[i] = cards[i].toUpperCase().replace("1C", "AC");
            break;
        case "13S":
            cards[i] = cards[i].toUpperCase().replace("13S", "KS");
            break;
        default:
            System.out.println(Arrays.toString(cards));
    }
}