grammar T;

options{
  output=AST;
}

@parser::members {
  public static void main(String[] args) throws Exception {
    TLexer lexer = new TLexer(new ANTLRStringStream("NVARCHAR"));
    TParser parser = new TParser(new CommonTokenStream(lexer));
    parser.type();
  }
}

type
  :  NVARCHAR {System.out.println("token=" + $NVARCHAR.text);}
  ;

NVARCHAR
  :  'NVARCHAR' {setText("VARCHAR");}
  ;