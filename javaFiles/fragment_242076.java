OutputStmt OutputStatement() :
{
  Token tk;
  Expression args;
  boolean ln;
  int line;
  int column;
}
{
  {line=token.beginLine;column=token.beginColumn;args=null;ln=false;}
  LOOKAHEAD({getToken(1).image.equals("System")})
  <ID> 
  "."
  LOOKAHEAD({getToken(1).image.equals("out")})
  <ID> 
  "."
  LOOKAHEAD({getToken(1).image.equals("println") || getToken(1).image.equals("print") })
  tk=<ID> { ln = tk.image.equals("println" ) ; }
  "("
     args=Expression()
  ")" ";"
  { return new OutputStmt(line,column,token.endLine,token.endColumn,ln,args); }
}