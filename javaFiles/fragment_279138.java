public String printGreeting(int choice, String[] clubName) {
    result = clubName;
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

    if (choice >= 1 && choice <= 20) {
        // assign choice to result
        result = clubName[choice - 1]; 
        // print choice
        System.out.println("You chose: " + result); // return the clubName -1
    } 

    // return the chosen club name
    return result; 
}