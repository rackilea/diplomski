public String generateCard() {
    int numberRandom = random.nextInt(numbers.length);
    int signRandom = random.nextInt(sign.length);
    String pickedNumber = numbers[numberRandom];
    String pickedSign = sign[signRandom];
    return pickedSign + pickedNumber;
}

public static boolean cardIsInHand(String card) {
    for(int i = 0; i < 5; i++) {
        if(hand[i] != null && hand[i].contains(card)) {
            return true;
        }
    }

    return false;
}

public static void handout() {
    for (int i = 0; i < 5; i++) {
        String card = generateCard();

        while(cardIsInHand(card)) {
            card = generateCard();
        }

        hand[i] = card;
    }
}