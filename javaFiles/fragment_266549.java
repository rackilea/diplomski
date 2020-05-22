class Exit extends RuntimeException {}

public void run() {
    try {
        /* Do your stuff, which may or may not entail calling end(). */
    } catch(Exit e) {
        return;
    }
}

public void end() {
    throw(new Exit());
}