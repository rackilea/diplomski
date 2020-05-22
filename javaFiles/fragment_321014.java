String first = input.substring(0,1);
String second = input.substring(1);
    if (!((first.equalsIgnoreCase("a") ||
                first.equalsIgnoreCase("b") ||
                first.equalsIgnoreCase("c")) && 
                (second.equals("1") ||
                second.equals("2") ||
                second.equals("3"))) {
        throw new InvalidInputException();
    }