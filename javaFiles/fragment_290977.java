import bsh.Interpreter;
Interpreter interpreter = new Interpreter();
interpreter.set("a1", 2);
interpreter.set("b1", 3);
String equation = "Math.pow(a1,b1)";
Object checkIt = interpreter.eval(equation);
System.out.println(checkIt);