private static int getInput() {
    int choice = menuSelect();
    while(choice < 1 || choice > 6) {
        System.out.println("Invalid choice, please re-enter")
        choice = menuSelect();
    }
    return choice;
}