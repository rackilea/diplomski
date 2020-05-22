interface AstNode {
   double eval(Scope scope); // you can look at scope as a HashMap<String, double>
}

class TerminalNode : AstNode {
   String varName;
   double constantValue;

   public TerminalNode(String varName) {
      this.varName = varName;
   }
   public TerminalNode(double constantValue) {
      this.constantValue = constantValue;
      this.varName = null;
   }

   public double eval(Scope scope) {
      if (varName == null) return constantValue;
      return scope.get(varName);
   }
}

class CallNode : AstNode {
   Function target;
   String[] parameters;
   AstNode[] children;

   public CallNode(Function target, String[] parameters, AstNode[] children) {
      this.target = target;
      this.parameters = parameters;
      this.children = children;
   }

   public double eval(Scope scope) {
      double[] subExpressions = new double[children.length];
      Scope innerScope = new Scope(scope); // creates a copy
      for (int i = 0; i < children.length; i++) {
         // I'm using the copy here because of the edge-case: f(x) = g(x) + x; g(x) = x * 2;
         // In this case, the x variable is overriden in the innerScope when we resolve g(x)
         // but we "stored" the previous x value in the "outerScope" so we can add it later
         subExpressions[i] = children[i].eval(scope);
         innerScope.set(target.getParamName(i), subExpressions[i]);
      }
      // usually, you could do target.getNode().eval(innerScope)
      // however, this would limit the target function to only be user-defined functions
      // we leave this way so you can override the Function's eval method to a built-in
      return target.eval(innerScope);
   }
}