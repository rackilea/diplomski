Context ctx = new Context(cfg);

EnumSort rSort = ctx.mkEnumSort(ctx.mkSymbol("res"), ctx.mkSymbol("res1"));
SetSort rSet = ctx.mkSetSort(rSort);
Expr rID = ctx.mkConst("rID", rSet);
BoolExpr c1 = (BoolExpr)ctx.mkSetMembership(rSort.getConsts()[0], rID);

Solver s = ctx.mkSolver();
s.add(c1);
Status status = s.check();
Model m = s.getModel();

System.out.println(status);
System.out.println("Model = " + m);

FuncInterp fi = m.getFuncInterp(rID.getFuncDecl());
System.out.println("fi="+ fi);