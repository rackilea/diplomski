public String printGreeting(int choice, String[] clubName) {
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // ??

    if (choice >= 1 && choice <= 20) {
        choice --; // if choice is valid, get the array position.
        // print choice
        System.out.println("You chose: " + clubName[choice]); 
        return clubName[choice]; 
    } 

    // if the choice is not correct, return null or "" as you want
    return null;
}