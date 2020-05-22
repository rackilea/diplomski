public void executeInNativeThreads(){

    // starts new thread and executes countA in it
    new Thread(this::countA).start();

    // starts new thread and executes countB in it
    new Thread(this::countB).start();

}