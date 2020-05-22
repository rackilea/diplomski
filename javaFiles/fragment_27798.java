package sandbox;

import java.util.List;
import sandbox.package2.UserBuilder;
import sandbox.pakcage1.Player;

public class Sandbox {
    public static void main(String[] args) {
        List<Player> players = UserBuilder.getUsers();

        for(Player player : players) {
            System.out.println(player.getName());
        }
    }
}