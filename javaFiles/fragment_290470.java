int number1 = -1;
    int number2 = -1;
    char operator = ' ';
    Scanner kb = new Scanner(System.in);
    System.out.println("Enter what you want to calculate");

    String line = kb.nextLine();
    String[] pieces = line.split("\\s+");
    boolean parsedInput = true;

    if(pieces.length == 3)
    {
        number1 = pieces[0].matches("\\d+") ? Integer.parseInt(pieces[0]) : Integer.MAX_VALUE;
        number2 = pieces[1].matches("\\d+") ? Integer.parseInt(pieces[1]) : (pieces[2].matches("\\d+") ? Integer.parseInt(pieces[2]) : Integer.MAX_VALUE);
        operator = pieces[1].matches("\\*|\\-|\\+") ? pieces[1].charAt(0) : (pieces[2].matches("\\*|\\-|\\+") ? pieces[2].charAt(0) : ' ');
        if(operator == ' ' || number1 == Integer.MAX_VALUE || number2 == Integer.MAX_VALUE)
            parsedInput = false;
    }

    if(parsedInput)
        System.out.println("Number 1: " + number1 + ", Number 2: " + number2 + ", Operator: " + operator);
    else
        System.out.println("Failed to parse: " + line);