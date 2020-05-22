} else if (ch >= 'a' && ch <= 'z') { // functions and variables
        while (ch >= 'a' && ch <= 'z') nextChar();
        String name = str.substring(startPos, this.pos);
        if (functions.containsKey(name)) {
            DoubleUnaryOperator func = functions.get(name);
            Expression arg = parseFactor();
            x = () -> func.applyAsDouble(arg.eval());
        } else {
            x = () -> variables.get(name);
        }
    } else {