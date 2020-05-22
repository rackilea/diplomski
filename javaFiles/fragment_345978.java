public void execute(Command command) {

    if (current == history.length - 1){                     // if full, then shift
        for (int i = 0; i < history.length - 1; i++) {
            history[i] = history[i+1];
        }
    } else {
        current++;
    }
    history[current] = command;
    history[current].execute();
}