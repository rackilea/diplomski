.
.
.
// there is no need to re-declare the Scanner object every iteration, or two scanners
Scanner keyboard = new Scanner(System.in);

do {
    String userOrder = keyboard.next().toLowerCase();

    // we haven't found the item
    boolean found = false;

    // integer option (yes or no)
    int option;

    // do the search
    for (int j = 0; j < menu.length; j++) {
        // do this if found
        if (userOrder.equals(menu[j])) {
            // set flag to indicate we found the item
            found = true;

            // add the order
            Order.add(userOrder);

            // print out, then read the user's option
            System.out.println("You ordered" + userOrder + "\nSomething more?" + "\nSay YES with 1 and NO with 0");
            option = keyboard.nextInt();

            // consume the NL leftover from the nextInt() call
            keyboard.nextLine();

            // break out of the for loop since you already found what you're looking for
            break;
        }
    }

    // check if you didn't find the item
    if (!found) {
        // print out
        System.out.println("We don't have this on menu!"
                            + "\nDo you want to order another thing that we do have in menu?" + "\nSay YES with 1 and NO with 0");

        // read if user wants to continue
        option = keyboard.nextInt();

        // consume the NL leftover from the nextInt() call
        keyboard.nextLine();        
    }
} while (option == yes);

System.out.println("Order finished!");
.
.
.
// close the scanner when you're done
keyboard.close();
.
.
.