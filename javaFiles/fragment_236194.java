class Field {

    // instance of the board
    private Board board; 

    public void moveTo(Player p){ 
        synchronized (board) {
            // move code goes here
        }
    }
}