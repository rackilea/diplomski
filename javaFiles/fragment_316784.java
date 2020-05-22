while (userInput.hasNext()) {
    if (userInput.hasNextInt()) {
        int intValue = userInput.nextInt();
        if (intValue > 0) {
            return intValue;
         }
    }
    userInput.next();
}