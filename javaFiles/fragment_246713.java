StringWriter out = new StringWriter();
PythonInterpreter interp = new PythonInterpreter();
interp.setOut(out);
interp.setErr(out);
interp.exec("print('hello world')");
String result = out.toString();
System.out.println("result: " + result);