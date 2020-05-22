public static void main(String[] args) {
    IPlayer human = new HumanPlayer(); // <-- you have to create this class (assignment)
    IPlayer computer = new ComputerPlayer20059226();
    Board board = new Board(16, 16);
    Connect4 connect = new Connect4(human, computer, board);
    // do something with the objects        
}