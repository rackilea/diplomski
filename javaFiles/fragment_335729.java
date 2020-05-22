private static void playGame(Scanner scan) {
        Deck deck = new Deck();
        String playGame;
        Integer yourScore = 0;
        Random random = new Random();
        Boolean playerEnough = false;
        Boolean dealerEnough = false;
        Integer dealerScore = 0;
        deck.shuffle();
        while ((yourScore <= 21 && dealerScore <= 21) && (!dealerEnough || !playerEnough)) {
            if (yourScore == 0) {
                yourScore += getCardScore(deck, "Player");
                yourScore += getCardScore(deck, "Player");
            }
            if (dealerScore == 0) {
                dealerScore += getCardScore(deck, "Dealer");
                dealerScore += getCardScore(deck, "Dealer");
            }
            if (!playerEnough) {
                System.out.println("Want a card?");
                playGame = scan.nextLine();
                if (playGame.equals("yes")) {
                    yourScore += getCardScore(deck, "Player");
                } else {
                    System.out.println("PlayerDone");
                    playerEnough = true;
                }
            }
            if (!dealerEnough) {
                if (random.nextBoolean()) {
                    dealerScore += getCardScore(deck, "Dealer");
                } else {
                    System.out.println("DealerDone");
                    dealerEnough = true;
                }
            }
            System.out.println(yourScore + " [p] : [d] " + dealerScore);    
        }
        // decide who is a winner
    }


    private static Integer getCardScore(Deck deck, String who) {
        System.out.print(who + " given: ");
        Cards cards = deck.cards.pollFirst();
        System.out.println(cards);
        return cards.getScore();
    }