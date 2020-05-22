try {
    p1.waitFor();
} catch (InterruptedException e) {
    Sys.err(e.toString());
    //don't ignore the exception:
    p1.destroy();
    Thread.currentThread.interrupt(); //reset interrupted flag
}