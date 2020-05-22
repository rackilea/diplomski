sentence
@init {
  CommonTree ahead = (CommonTree)input.LT(1);
  int line = ahead.getToken().getLine();
  System.out.println("line=" + line);
}
  :  assignCommand 
  |  actionCommand
  ;