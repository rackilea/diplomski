RepeatStatement repeat_statement() throws ParseException {
    if (!consume("REPEAT")) {
        throw new ParseException("no REPEAT token");
    }
    Statement statement = statement();
    if (!consume("UNTIL")) {
        throw new ParseException("no UNTILtoken");
    }
    Expression expression = expression();
    if (!consume(";")) {
        throw new ParseException("no closing semicolon");
    }
    return new RepeatStatement(statement, expression);
}