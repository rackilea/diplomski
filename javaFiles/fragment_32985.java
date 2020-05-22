grammar T;

options{
  output=AST;
}

tokens {
  VARCHAR='VARCHAR';
}

@parser::members {
  public static void main(String[] args) throws Exception {
    TLexer lexer = new TLexer(new ANTLRStringStream("NVARCHAR"));
    TParser parser = new TParser(new CommonTokenStream(lexer));
    parser.type();
  }
}

type
  :  NVARCHAR -> VARCHAR
  ;

NVARCHAR
  :  'NVARCHAR'
  ;