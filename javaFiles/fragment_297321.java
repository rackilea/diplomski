private static void mainMenu() {
    boolean askForAnother = true;
    while(askForAnother) {
        char option = getOptionFromUser();
        switch(option) {
            ... as above
            case '4':
               askForAnother = false;
        }
    }
    ... will go here when user types '4', you can do other stuff if desired
}