int snackChoice;
do {
    System.out.println("Would you like to add any snacks? ");
    System.out.println("1: ($5) Large Popcorn");
    System.out.println("2: ($0) Nothing Else");
    snackChoice = input.nextInt();

    System.out.println("How many of option " + snackChoice + " would you like? ");
    System.out.println("1: One");
    System.out.println("2: Two");
    System.out.println("3: Three");
    System.out.println("4: Four");
    System.out.println("5: Five");
    int snackAmount = input.nextInt();

    switch (snackChoice) { 
    case 1: 
        cost = cost + 5 * snackAmount;
        System.out.println("Your total before tax will be: $" + cost + (5 * snackAmount)); 
    break;

    default: 
        System.out.println("Not a valid option."); 
    break;

    }
}
while(snackChoice != 9);