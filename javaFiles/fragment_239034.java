//infinit loop, until user enter the `q` or the input is correct
 while (true) {

    //read the input
    theVariable = scan.nextLine();

    //chtck, whether is `quit` command entered
    if ("q".equals(theVariable)) {
        break;
    }

    //if string starts with digit or contains some whitespaces
    //then print alert and let the user to 
    //modify the input in a new iteration
    if (theVariable.matches("^\d+.*|.*\s+.*")) {
        System.out.println("The variable is illegal");
        continue;
    }

    //if string contains some special characters print alert 
    //and let the user to modify the input in a new iteration
    if (theVariable.matches("^[!@#$%^&*].*")) {
        System.out.println("The variable is legal, but has bad style");
        continue;
    }

    //if all the conditions checked, then break the loop
    break;
}