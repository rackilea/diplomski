Goal g = this.context.mkGoal(true, false, false);
g.add((BoolExpr) expr);

ApplyResult ar = this.context.mkTactic("ctx-solver-simplify").apply(g);
Goal[] subgoals = ar.getSubgoals();
BoolExpr[] formulas_0 = subgoals[0].getFormulas();