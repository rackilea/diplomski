while (!name.equals(term)) { // will continue as long as name does not equal "stop"
    System.out.print("Enter the employee's name or stop if finished: ");
    name = input.nextLine(); // assigns the value input for name

    // all your stuff... 

    System.out.print("Enter " + employeeName + "'s pay rate: ");
    rate = input.nextDouble(); // assigns the value input for rate

    // some more stuff... 

    if(input.hasNextLine()) {
        input.nextLine();
    }
}