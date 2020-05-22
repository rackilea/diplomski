case StreamTokenizer.TT_NUMBER:
    Double value = new Double(tokenizer.nval);

    if (Character.isDigit(value.intValue()) {
        operands.add(value.doubleValue());

    } else {
        // Possibly dealing with operator here.  The hard/fun part is
        // in coercing that double value back to its tokenized string
        // form.
        operate(new Character((char) tokenizer.nval).toString());
    }

    break;