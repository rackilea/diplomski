public static void main(String[] args) throws Exception {

    GUI gui = new GUI();

    // Do some things
    doSomething();
    doSomthingElse();

    // Make sure we wait until gui input has been collected before proceeding
    synchronized(gui) {
        try {
            gui.wait();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    // Do some things using the gui input we've been waiting for        
    doSomeMoreThings();
}