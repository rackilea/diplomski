package casino;

import java.util.*;
import java.util.stream.Collectors;

public class Casino {
    public static void main(String[] args) {
        List<Player> players = Arrays.asList("Bob", "Jill", "Thomas").stream()
                .map(Player::new).collect(Collectors.toList());
        TexasHoldem holdem = new TexasHoldem();

        holdem.dealCards(players, 2);
        holdem.sortHands(players);
        holdem.play(players);
        holdem.printInfo(players);
    }
}