@parser::members {
  public static void main(String[] args) throws Exception {
    String src = "likes(a, b) :- likes(a, X), likes(X, b). hates(a, b) " + 
        ":- hates(a,X), hates(X,b). likes(a,b) :- says(god, likes(a,b)).";
    TLexer lexer = new TLexer(new ANTLRStringStream(src));
    TParser parser = new TParser(new CommonTokenStream(lexer));
    String s;
    while((s = parser.parse()) != null) {
      System.out.println(s);
    }
  }
}

parse returns [String s]
  :  statement ~(TEXT| EOF)* {$s = $statement.text;}
  |  EOF                     {$s = null;}
  ;