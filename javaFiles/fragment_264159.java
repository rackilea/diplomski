int i = 0;
for (String card : cards) {
    switch (card.toUpperCase()) {
        case "1C":
            cards[i] = card.toUpperCase().replace("1C", "AC");
            break;
        case "13S":
            cards[i] = card.toUpperCase().replace("13S", "KS");
            break;
        default:
            System.out.println(Arrays.toString(cards));
    }
    i++;
}