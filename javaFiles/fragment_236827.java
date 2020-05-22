code1:
    private boolean trackErrors = true;

code2:
    void error(TokeniserState state) {
        if (trackErrors)
            errors.add(new ParseError("Unexpected character in input", reader.current(), state, reader.pos()));
    }