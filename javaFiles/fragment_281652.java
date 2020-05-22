StringBuilder cardAndSuit = new StringBuilder();

    switch (valueofCard) {
        case "A":
            cardAndSuit.append("Ace of");
    .....


     switch (suitofCard) {
        case "D":
             cardAndSuit.append("Diamonds");
            break;   
    ...

    // Print the final string
    System.out.println(cardAndSuit.toString()); // Ace of Diamonds