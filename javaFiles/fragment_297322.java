private static void mainMenu() {
    boolean done = false;
    do {
        char option = getOptionFromUser();
        switch(option) {
            ... as above
            case '4':
                done = true;
        }
    } while (!done);
}