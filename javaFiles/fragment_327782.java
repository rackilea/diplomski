for (; i < 10000; i++) {
    solver.push();
    solver.add(expr);
    status = solver.check();
    solver.pop();
}