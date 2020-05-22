configure("../yourClasspath/");
SootClass sootClass = Scene.v().loadClassAndSupport("className");
sootClass.setApplicationClass();

// Retrieve the method and its body
SootMethod m = c.getMethodByName("methodName");
Body b = m.retrieveActiveBody();

// Instruments bytecode
new YourTransform().transform(b);