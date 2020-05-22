private static void mainMenu() {
    while(true) {
        char option = getOptionFromUser();
        switch(option) {
            case '1':
                addRecord();
                break;
            case '2':
                deleteRecord();
                break;
            case '3':
                updateRecord();
                break;
            case '4':
                return;
        }
    }
}