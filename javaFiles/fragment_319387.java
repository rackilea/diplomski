public Plus(Object a, Object b) {
    Expression exprA = convertToExpression(a);
    Expression exprB = convertToExpression(b);
    if(exprA == null || exprB == null) {
        // could error handle here or in the place below
    }
    // do initialization here
}
//
public Expression convertToExpression(Object obj) {
    Expression exprObj = null;
    if(obj instanceof String) {
        exprObj = new Var(obj);
    } else if(obj instanceof Double) {
        exprObj = new Num(obj);
    } else {
        // error handle here or in the place above
    }
    return exprObj;
}