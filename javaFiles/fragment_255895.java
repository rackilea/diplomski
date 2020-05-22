public void checkSyntax(String rule) {
      // TODO Auto-generated method stub
      try {
         CharStream stream=new ANTLRInputStream(decodeRule(rule));
         RuleExpLexer lexer=new RuleExpLexer(stream);
         CommonTokenStream tokens=new CommonTokenStream(lexer);
         RuleExpParser parser=new RuleExpParser(tokens);
         parser.start();
      } catch (Exception e) {
         // TODO: handle exception
         throw new ApplicationExceptions("uacRule is Wrong");
      }
   }