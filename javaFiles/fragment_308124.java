while(inputFile.hasNext()) {
    if(inputFile.hasNextDouble()) {

        // the next token is a double
        // so read it as a double
        double d = inputFile.nextDouble();

    } else {

        // the next token is not a double
        // so read it as a String
        String s = inputFile.next();
    }
}