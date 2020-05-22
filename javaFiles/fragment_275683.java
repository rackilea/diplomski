public void runApplication() {
    // init Scanner
    boolean nextRound = true;
    while(nextRound) {
        displayMenu();
        int input = sc.nextInt();
        switch(input) {
            case 1: // do stuff
                break;
            case 2: // this is the exit command
                nextRound = false;
                break;
            // more cases
            default:
                // undefined input
        }
    }
}