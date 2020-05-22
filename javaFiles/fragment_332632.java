if (expr instanceof IloLinearNumExpr) {
    IloLinearNumExpr lexpr = (IloLinearNumExpr) expr;

    IloLinearNumExprIterator it = lexpr.linearIterator();

    while (it.hasNext()) {
        IloNumVar var = it.nextNumVar();
        double coeff = it.getValue();
        System.out.println(var + " " + coeff);
    }
}