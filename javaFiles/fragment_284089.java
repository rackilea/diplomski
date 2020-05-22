CSVLexer lexer = new CSVLexer(new ANTLRInputStream("a,b,\"c\"\"c\""));
CommonTokenStream tokens = new CommonTokenStream(lexer);
tokens.fill();

for (Token token : tokens.getTokens()) {
    if (token.getType() == Token.EOF) {
        break;
    }
    System.out.printf("%-12s --> %s\n", CSVLexer.ruleNames[token.getType() - 1], token.getText());
}