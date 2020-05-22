@Override
public Formula visitPlusMinusExpr(formulaParser.PlusMinusExprContext ctx) {
    if( debug ) LOG.log(Level.INFO, "visitPlusMinusExpr " + ctx.getText());
    Formula formulaExpr = visit(ctx.expr());
    if( ctx.MINUS() == null ) return formulaExpr;
    else {
        if(formulaExpr instanceof DoubleFormula){
            // optimization for numeric values: we don't return "(0.0 MINUS THEVALUE)" but directly "-THEVALUE"
            Double v = - ((DoubleFormula) formulaExpr).getValue();
            return new DoubleFormula( v );
        } else {
            return ArithmeticOperator.MINUS( 0, formulaExpr);
        }
    }
}