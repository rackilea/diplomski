public static String parse(String text) throws ParseCancellationException {
   MyLexer lexer = new MyLexer(new ANTLRInputStream(text));
   lexer.removeErrorListeners();
   lexer.addErrorListener(ThrowingErrorListener.INSTANCE);

   CommonTokenStream tokens = new CommonTokenStream(lexer);

   MyParser parser = new MyParser(tokens);
   parser.removeErrorListeners();
   parser.addErrorListener(ThrowingErrorListener.INSTANCE);

   ParserRuleContext tree = parser.expr();
   MyParseRules extractor = new MyParseRules();

   return extractor.visit(tree);
}