System.out.println("Enter yes if you would like to cash out and use remaining balance to play and no if you would like to stop");
String decision = input.next();
if ("Yes".equalsIgnoreCase(decision)) { // Cashing Out
    budget = budget - 5000;
    System.out.println("Budget After play " + budget);
    continue;
}
break; // breaking the loop (if user enters anything other than yes)