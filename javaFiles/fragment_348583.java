class Server {
private ServerSocket serverSocket;
private static SharedBoard board;

static {
    board = new SharedBoard();
}

// The set of all the print writers for all the clients, used for broadcast.
private Set<PrintWriter> writers = new HashSet<>();

public Server(ServerSocket serverSocket) {
    this.serverSocket = serverSocket;
}

public static SharedBoard getBoard() {
    for (int i = 0; i < 9; i++)
        System.out.println(board.moves[i]);
    return board;
    }
}