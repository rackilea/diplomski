protected void expression() throws ParseException  {

    prefixSuffix(); 

    Token t = it.peekNext();
    while(t!=null) {
        if(t.isBinary()) {
            OperatorToken ot = (OperatorToken)t;
            Operator op = ot.getBinaryOp();
            pushOp(op,ot);
            it.consume();
            prefixSuffix();
        }
        else if(t.isTernary()){
            OperatorToken ot =(OperatorToken)t;
            Operator to = ot.getTernaryOp();
            pushOp(to,ot);
            it.consume();
            prefixSuffix();
        }
        else
            break;
        t=it.peekNext();
    }
    // read all remaining elements off the stack
    while(!sentinel.equals(ops.peek())) {
        popOp();
    }
}