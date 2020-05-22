private static String turn = ""; // must initialize or you ll get an NPE

public void playTurn() {
    synchronized(turn) {
         //...
         turn = msg; // (1)
         //...
    }
}