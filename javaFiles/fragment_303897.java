public synchronized void functionOne() {

    // do something

    functionTwo();

    // do something else

    // redundant, but permitted...
    synchronized(this) {
        // do more stuff
    }    
}

public synchronized void functionTwo() {
     // do even more stuff!
}