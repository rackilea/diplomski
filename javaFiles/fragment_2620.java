Key key = terminal.readInput();
while(key == null) {
    Thread.sleep(5); //whatever low value
    key = terminal.readInput();
}
// here key will not be null, so no NullPointerException