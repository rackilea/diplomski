grammar T;

@parser::members {
  public static void main(String[] args) throws Exception {
    String src = "likes(a, b) :- likes(a, X), likes(X, b). hates(a, b) " + 
        ":- hates(a,X), hates(X,b). likes(a,b) :- says(god, likes(a,b)).";
    TLexer lexer = new TLexer(new ANTLRStringStream(src));
    TParser parser = new TParser(new CommonTokenStream(lexer));
    List<String> statements = parser.parse();
    for(String s : statements) {
      System.out.println(s);
    }
  }
}

parse returns [List<String> statements]
@init{$statements = new ArrayList<String>();}
  :  (statement {$statements.add($statement.text);} ~TEXT+)+ EOF
  ;

statement
  :  TEXT OPAR params CPAR
  ;

params
  :  (param (COMMA param)*)?
  ;

param
  :  TEXT
  |  statement
  ;

COMMA : ',';
OPAR  : '(';
CPAR  : ')';
TEXT  : ('a'..'z' | 'A'..'Z')+;
SPACE : (' ' | '\t') {$channel=HIDDEN;};
OTHER : . ;