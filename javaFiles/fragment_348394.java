public class Game<T extends Player> {

    private List<T> players;

    public T getPlayer(int index) {
        return players.get(index);
    }
}

public class Player {
  private String username;
  private String email;
}

public class ChessPlayer extends Player {

}

public class Chess extends Game<ChessPlayer> {

}