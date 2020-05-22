grammar REPL;

@parser::members {

  boolean programDeclDone;
  boolean usesDeclAllowed;

  public REPLParser() {
    super(null);
    programDeclDone = false;
    usesDeclAllowed = true;
  }

  public void process(String source) throws Exception {
    ANTLRStringStream in = new ANTLRStringStream(source);
    REPLLexer lexer = new REPLLexer(in);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    super.setTokenStream(tokens);
    this.parse();
  } 
}

parse
  :  programDeclaration EOF
  |  {programDeclDone}? (usesDeclaration | statement) EOF
  ;

programDeclaration
@after{
  programDeclDone = true;
}
  :  {!programDeclDone}? PROGRAM ID {System.out.println("\t\t\t program <- " + $ID.text);}
  ;

usesDeclaration
  :  {usesDeclAllowed}? USES idList {System.out.println("\t\t\t uses <- " + $idList.text);}
  ;

statement
@after{
  usesDeclAllowed = false; 
}
  :  left=ID '=' right=(INT | ID) {System.out.println("\t\t\t " + $left.text + " <- " + $right.text);}
  ;

idList
  :  ID (',' ID)*
  ;

PROGRAM : 'program';
USES    : 'uses';
ID      : ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;
INT     : '0'..'9'+;
SPACE   : (' ' | '\t' | '\r' | '\n') {skip();};