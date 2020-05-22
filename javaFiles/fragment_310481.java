String userInput = getWhatUserEntered();
    try {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition position = new ParsePosition(0);
        Number number = formatter.parse(userInput, position);
        if (position.getIndex() != userInput.length())
            throw new ParseException("failed to parse entire string: " + userInput, position.getIndex());
        doSomething(number);    // If I reach here, I will doSomething

        return;
    }
    catch(Exception e)  {
        // Oh.. user has entered mixture of alpha and number
    }

    doSomethingElse(userInput);  // If I reach here, I will doSomethingElse
    return;