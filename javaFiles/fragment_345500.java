IloCplex cplex = new IloCplex();
IloNumVar x = cplex.numVar(-100, 100);
IloNumVar a = cplex.intVar(0, 1);

cplex.ifThen(cplex.ge(x, 100), cplex.eq(a, 1));
cplex.ifThen(cplex.eq(x, 0), cplex.eq(a, 0));