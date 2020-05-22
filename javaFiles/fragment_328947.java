class Player extends Character {

    private final static Player me = new Player();

    // if you don't want anyone creating player objects
    // make the constructor private:
    private Player(){ super(); }

    public void doSomething(){
        // stuff
    }

    public static void staticDoSomething(){ me.doSomething(); }
}