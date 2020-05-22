remainingLowerCards = 0;
remainingHigherCards = 0;
for (int x = 0; x < cardCounter.length; x++) {
    remainingCards = remainingCards + cardCounter[x];
    if (x < flipInt - 1) {
        remainingLowerCards += cardCounter[x];
    } else if (x >= flipInt) {
        remainingHigherCards += cardCounter[x];
    }
}

chanceLower = ((double) remainingLowerCards) / remainingCards;
System.out.println("Lower: " + remainingLowerCards + " / " + remainingCards + " = " + chanceLower);

// This line should output 0.98039215686 given the input of 'a'
chanceHigher = ((double) remainingHigherCards) / remainingCards;
System.out.println("Higher: " + remainingHigherCards + " / " + remainingCards + " = "
        + chanceHigher);