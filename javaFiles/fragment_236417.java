try {
    int number = Integer.parseInt(input);
    // no exception thrown, that means its a valid Integer
} catch(NumberFormatException e) {
    // invalid Integer
}