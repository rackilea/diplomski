public void refuteSuggestion(Weapon w, Character c, int currentPlayerNumber) {
    for (Player p : game.getPlayers()) {
        if(currentPlayerNumber != 6) {
            if (p.getNum() == currentPlayerNumber + 1) {

                  nextFunction(p);
            } else {
                currentPlayerNumber += 1;
            }
        }
        else{
            currentPlayerNumber = 0;
        }

    }
    System.out.println("No one refuted...");
}

public void nextFunction(Player p){
    Set<Card> cardSet = new HashSet<>();
    cardSet.addAll(p.getPlayerCards());
    Card card = (Card) getRandomObject(cardSet);
    System.out.println(card.getName(0));
  }