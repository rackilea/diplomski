class Player extends Character {

    private static Player thePlayer = null;

    public static Player getPlayer(){
        if( thePlayer == null ){
            // Create the player
            thePlayer = new Player();
        }
        // There is a valid player object, so return it.
        return thePlayer;
    }

    // hide the constructor(s) by making them private:

    private Player(){ super(); }
}