public class Game {

    private static class PlayBoard {

        private int movesLeft;
        private List<Player> players;
        private int playerToMove;

        PlayBoard(int movesLeft) {
            this.movesLeft = movesLeft;
        }

        void setParties(Player... players) {
            this.players = Arrays.asList(players);
            this.players.forEach((Player player) -> player.prepareForGame(this));
            playerToMove = 0;
        }

        boolean isActive() {
            return movesLeft > 0;
        }

        boolean canIMove(Player player) {
            return players.get(playerToMove) == player;
        }

        void takeMove(Player player) {
            playerToMove = players.indexOf(player);
            movesLeft--;
            System.out.printf("%s's making move. %d moves left\n", player.name, movesLeft);
            playerToMove = (playerToMove + 1) % players.size();
        }
    }

    private static class Player {

        private final String name;
        private PlayBoard playBoard;

        Player(String name) {
            this.name = name;
        }

        void prepareForGame(PlayBoard playBoard) {
            this.playBoard = playBoard;
        }

        void play() {
            synchronized (playBoard) {
                while (playBoard.isActive()) {
                    if (playBoard.canIMove(this)) {
                        playBoard.takeMove(this);
                        playBoard.notifyAll();
                    } else {
                        try {
                            playBoard.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PlayBoard playBoard = new PlayBoard(12);
        playBoard.setParties(new Player("Lea"),
                             new Player("Susan"),
                             new Player("Daria"));

        List<Thread> threads = playBoard.players.stream()
            .map(player -> new Thread(player::play))
            .collect(Collectors.toList());

        threads.forEach(Thread::start);
        for (Thread thread : threads) {
            thread.join();
        }
    }
}