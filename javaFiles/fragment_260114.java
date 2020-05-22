package casino;

import java.util.List;

public class TexasHoldem {
    private Deck deck;
    private Hand communityHand;

    public TexasHoldem() {
        deck = new Deck();
        communityHand = new Hand();
        deck.shuffle();
    }

    void printInfo(List<Player> players) {
        System.out.println("# INFO");
        System.out.println(deck);
        System.out.println(communityHand);
        players.stream().forEach(System.out::println);
    }

    void play(List<Player> players) {
        for (int i = 0; i < 5; i++) {
            communityHand.insert(deck.draw());
            if (i == 2) {
                System.out.println("# FLOP");
                compareHands(players, communityHand);
                System.out.println();
            }
            if (i == 3) {
                System.out.println("# TURN");
                compareHands(players, communityHand);
                System.out.println();
            }
            if (i == 4) {
                System.out.println("# RIVER");
                compareHands(players, communityHand);
                System.out.println();
            }
        }
    }

    public Hand viewHand(Player player, Hand community) {
        Hand view = new Hand();
        for (Card card : player.getHand().getCards()) {
            view.insert(card);
        }
        for (Card card : community.getCards()) {
            view.insert(card);
        }
        return view;
    }

    public void compareHands(List<Player> players, Hand community) {
        for (Player player : players) {
            Hand view = viewHand(player, community);
            view.sort();
            System.out.printf("%s => %s%n", player, view);
        }
    }

    public void dealCards(List<Player> players, int cardsPerPlayer) {
        for (int round = 0; round < cardsPerPlayer; round++) {
            for (Player player : players) {
                player.getHand().insert(deck.draw());
            }
        }
    }

    void sortHands(List<Player> players) {
        for (Player player : players) {
            player.getHand().sort();
        }
    }
}