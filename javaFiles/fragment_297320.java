private static void mainMenu() {
    menuLoop:
    while(true) {
        char option = getOptionFromUser();
        switch(option) {
            ... as above
            case '4':
                break menuLoop;
        }
    }
    ... will go here when user types '4', you can do other stuff if desired
}