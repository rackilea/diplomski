do {
    System.out.print(motherHeightPrompt);
    try {
        motherHeight = Float.parseFloat(stdIn.nextLine()); // This will read the line and try to parse it to a floating value
        valid = true;
    } catch (NumberFormatException e) { // if it was not a valid float, you'll get this exception
        System.out.println(motherError2);
            // You need not have that extra stdIn.next()
            // it loops again, prompting the user for another input
    }
} while (!valid); // The loop ends when a valid float is got from the user