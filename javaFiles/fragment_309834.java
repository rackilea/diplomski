Solver solver = new Solver();

int n = 10;
IntVar[] x = VariableFactory.boundedArray("x", n, 0, 500, solver);

IntVar min = VariableFactory.bounded("min", 0, 500, solver);
IntVar max = VariableFactory.bounded("max", 0, 500, solver);

solver.post(IntConstraintFactory.minimum(min, x));
solver.post(IntConstraintFactory.maximum(max, x));

solver.post(IntConstraintFactory.distance(min, max, "<", 100));

if (solver.findSolution()) {
    int solutions = 5;
    int nSol = 0;
    do {
        System.out.print("x: ");
        for (int i = 0; i < n; i++)
            System.out.print(x[i].getValue() + " ");
        System.out.println("\nmin = " + min.getValue() + ", max = " + max.getValue() + ", |min - max| = " + Math.abs(min.getValue() - max.getValue()) + "\n");

        nSol++;

        if (solutions > 0 && nSol >= solutions)
            break;
    } while (solver.nextSolution());

    System.out.println(nSol + " solutions found.");
} else {
    System.out.println("No solution found.");
}