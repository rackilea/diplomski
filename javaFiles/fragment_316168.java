Scope scope = new Scope();
scope.set("x", 4);
scope.set("y", 2);
// remember I stored the function f on the object g, just to make a distinction
// also, note this is equivalent to g.getNode().eval(scope), because the function stored in g is not a built-in!
System.out.println(g.eval(scope));