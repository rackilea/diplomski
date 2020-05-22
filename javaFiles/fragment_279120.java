catch (NumberFormatException nfe) { 
    System.out.println("Error! Please enter a number!" + nfe.toString());  //Error message if its not a double
    //again ask for input
    System.out.print("\nPlease enter a number for Total Impulse: ");
    return totalImpulse1();
}