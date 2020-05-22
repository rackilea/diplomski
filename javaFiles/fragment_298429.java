// test printing string array
    for (String s : lines)
    {
        System.out.println("" + s);
        String[] output =infixToRPN(lines);
        System.out.println(RPNtoDouble(output));

    }