tree grammar ASTDemoWalker;

options {
  output=AST;
  tokenVocab=ASTDemo;
  ASTLabelType=CommonTree;
}


walk
  :  ^(ROOT sentence+)
  ;

sentence
@init {
  CommonTree ahead = (CommonTree)input.LT(1);
  int line = ahead.getToken().getLine();
  System.out.println("line=" + line);
}
  :  assignCommand 
  |  actionCommand
  ;

assignCommand
  :  ^(ASSIGN ID NUMBER)
  ;

actionCommand
  :  ^(ACTION action ID)
  ;

action
  :  START
  |  STOP
  ;