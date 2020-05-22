grammar T;

@parser::members {

  public static boolean matches(String input) {
    try {
      TLexer lexer = new TLexer(new ANTLRStringStream(input));
      TParser parser = new TParser(new CommonTokenStream(lexer));
      parser.parse();
      return true;
    } catch(Exception e) {
      return false;
    }
  }

  @Override
  public void reportError(RecognitionException e) {
    throw new RuntimeException(e); 
  }
}

@lexer::members {
  @Override
  public void reportError(RecognitionException e) {
    throw new RuntimeException(e); 
  }
}

parse
 : NUMBER* EOF
 ;

NUMBER : '0'..'9'+;
SPACE  : ' ' {skip();};