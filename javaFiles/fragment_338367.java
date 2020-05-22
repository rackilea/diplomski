while (interpreter.hasNext()) {

    // Do we have the beginning of a number?
    if (interpreter.hasNext(tokenPattern)) {
        // Extract the full number
        String strVal = interpreter.findInLine(findPattern);
        float value = Float.parseFloat(strVal);
        tokenList.add(new Token(11, value));

    }
    else{
        // Handle single char token
    }
 }