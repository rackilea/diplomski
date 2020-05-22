public NetworkThread(Socket newClient, String userName, int id) {
    ...
    ConstructFrame();
    // don't do the interactive work in the constructor
}

@Override
public void run() {
    // do it in the background thread
    if (id == 1)
        changeTurnAsAGuesser();
    else
        startConnectionForSecondPlayer();
}