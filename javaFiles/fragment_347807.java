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
    this.parse(); // the entry point of our parser
  } 
}