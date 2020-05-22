PythonInterpreter interpreter = new PythonInterpreter();
interpreter.exec("import sys\nsys.path.append('myPath')\nimport jythonFirst");

PyObject jythonFirst = interpreter.get("jythonFirst");
PyObject someFunc = jythonFirst.__getattr__(Py.newString("printAndReturn"));
PyObject result = someFunc.__call__();

String realResult = (String) result.__tojava__(String.class);
System.out.println(realResult);