/**
 * Compare operators based on their precedence and associativity.
 * @param op1
 * @param op2
 * @return true if op1 has a lower precedence than op2, or equal precedence and a left assoc op, etc.
 */
protected boolean compareOps(Operator op1,Operator op2)
{
    if(op1.isTernary() && op2.isTernary()) {
        if(op1 instanceof TernaryOperator.RhsTernaryOperator &&
                op2 instanceof TernaryOperator.RhsTernaryOperator )
            return true;
        return false;
    }
    if(op1 == sentinel ) return false;
    if(op2 == sentinel ) return true;
    if(op2.isPrefix() && op1.isBinary()) return false;
    if(op1.getPrecedence() < op2.getPrecedence()) return true;
    if(op1.getPrecedence() == op2.getPrecedence() && op1.isLeftBinding()) return true;
    return false;
}