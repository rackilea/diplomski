protected void pushOp(Operator op,Token tok) throws ParseException 
{
    while(compareOps(ops.peek(),op))
        popOp();
    ops.push(op); 
}