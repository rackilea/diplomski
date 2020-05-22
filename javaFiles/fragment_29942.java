if(command.equals("write")) {
    // Make sure the user put the right stuff in here
    // Since we removed the command from the input already, just make sure what is left is 
    if(input.size() <= 1) {
        throw new IllegalArgumentException("Must specify correct data");
    }
    String key = input.remove(0);
    String value = String.join(" ", input); // Java 8
    instruct.mapWrite(key, value);
}