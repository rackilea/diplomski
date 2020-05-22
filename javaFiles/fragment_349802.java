// extract the operands and operator
    String[] operandsArrStr = "22+ 2".replaceAll("\\s+", "").split("[\\+\\-\\/\\*]"); // {"22", "2"}
    String operator = "22+ 2".replaceAll("(\\s+|\\d+|\\.)", ""); // "+"

    // convert the values to doubles
    Double[] operands = new Double[operandsArrStr.length];
    for (int i=0; i < operandsArrStr.length; i++) {
        operands[i] = new Double(operandsArrStr[i]);
    }

    Double res = null;
    // calc
    if ("+".equals(operator)) {
        res = operands[0] + operands[1]; // assuming only two operands and one operator!
    }
    else if ("-".equals(operator)) {
        res = operands[0] - operands[1];
    }
    else if ("/".equals(operator)) {
        res = operands[0] / operands[1];
    }
    else if ("*".equals(operator)) {
        res = operands[0] * operands[1];
    }
    System.out.println("res = " + res); // prints 24.0