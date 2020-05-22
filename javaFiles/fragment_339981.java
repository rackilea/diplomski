String input = "Yes";
while(input.equalsIgnoreCase("Yes")) {
    System.out.println ("How many of the first item did you get? ");
    quantity1 = kb.nextInt();

    System.out.println ("What was the price of that single item? ");
    unitPrice1 = kb.nextDouble();

    //total += unitPrice1 * quantity1 - you don't have this in your code, but this is where you would be calculating the running total

    System.out.println("Was there another food item you'd like to add? ");
    input = kb.next();
}