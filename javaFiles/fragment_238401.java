// example.java
import gurobi.*;

public class example {
  public static void main(String[] args) {
    try {
      GRBEnv    env   = new GRBEnv("example.log");
      GRBModel  model = new GRBModel(env);

      // Create variables
      GRBVar r1 = model.addVar(0.0, GRB.INFINITY, 0.0, GRB.CONTINUOUS, "r1");
      GRBVar r2 = model.addVar(0.0, GRB.INFINITY, 0.0, GRB.CONTINUOUS, "r2");
      GRBVar r3 = model.addVar(0.0, GRB.INFINITY, 0.0, GRB.CONTINUOUS, "r3");
      GRBVar z = model.addVar(-GRB.INFINITY, GRB.INFINITY, 1.0, GRB.CONTINUOUS, "z");

      // Set objective: minimize z
      GRBLinExpr expr = new GRBLinExpr();
      expr.addTerm(1.0, z);
      model.setObjective(expr, GRB.MINIMIZE);

      // Add constraint: r1 + r2 + r3 = 1
      expr = new GRBLinExpr();
      expr.addTerm(1.0, r1); expr.addTerm(1.0, r2); expr.addTerm(1.0, r3);
      model.addConstr(expr, GRB.EQUAL, 1.0, "c0");

      // Add constraint: 15 * (1-r1) <= z  <-> -15 r1 - z <= -15
      expr = new GRBLinExpr();
      expr.addTerm(-15.0, r1); expr.addTerm(-1.0, z);
      model.addConstr(expr, GRB.LESS_EQUAL, -15.0, "c1");

      // Add constraint: 12 * (1-r2) <= z  <-> -12 r2 - z <= -12
      expr = new GRBLinExpr();
      expr.addTerm(-12.0, r2); expr.addTerm(-1.0, z);
      model.addConstr(expr, GRB.LESS_EQUAL, -12.0, "c1");

      // Add constraint: 12 * (1-r3) <= z  <-> -12 r3 - z <= -12
      expr = new GRBLinExpr();
      expr.addTerm(-12.0, r3); expr.addTerm(-1.0, z);
      model.addConstr(expr, GRB.LESS_EQUAL, -12.0, "c1");

      // Add constraint: 240 r1 <= z  <-> 240 r1 - z <= 0
      expr = new GRBLinExpr();
      expr.addTerm(240.0, r1); expr.addTerm(-1.0, z);
      model.addConstr(expr, GRB.LESS_EQUAL, 0.0, "c1");

      // Add constraint: 27 r2 <= z  <-> 27 r2 - z <= 0
      expr = new GRBLinExpr();
      expr.addTerm(27.0, r2); expr.addTerm(-1.0, z);
      model.addConstr(expr, GRB.LESS_EQUAL, 0.0, "c1");

      // Add constraint: 27 r3 <= z  <-> 27 r3 - z <= 0
      expr = new GRBLinExpr();
      expr.addTerm(27.0, r3); expr.addTerm(-1.0, z);
      model.addConstr(expr, GRB.LESS_EQUAL, 0.0, "c1");

      // Optimize model
      model.write("model.lp");
      model.optimize();

      System.out.println(r1.get(GRB.StringAttr.VarName)
                         + " " +r1.get(GRB.DoubleAttr.X));
      System.out.println(r2.get(GRB.StringAttr.VarName)
                         + " " +r2.get(GRB.DoubleAttr.X));
      System.out.println(r3.get(GRB.StringAttr.VarName)
                         + " " +r3.get(GRB.DoubleAttr.X));

      System.out.println("Obj: " + model.get(GRB.DoubleAttr.ObjVal));

      // Dispose of model and environment

      model.dispose();
      env.dispose();

    } catch (GRBException e) {
      System.out.println("Error code: " + e.getErrorCode() + ". " +
                         e.getMessage());
    }
  }
}