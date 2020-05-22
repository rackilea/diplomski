do {
    System.out.print("Please enter a valid 2-4 digit number: ")
    value = input.next();
    int valueInt = Integer.parseInt(value);
} while (valueInt < 10 || valueInt > 9999);
//only get here when inputted value finally within target range.