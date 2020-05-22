PythonInterpreter.initialize(System.getProperties(), System.getProperties(), new String[0]);
PythonInterpreter interpreter = new PythonInterpreter();
interpreter.exec("import sys");
interpreter.exec("sys.path.append('<dir>')");
interpreter.exec("sys.path.append('/home/<user>/.local/lib/python2.7/site-packages')");
interpreter.exec("import import_ical");
// set variables if necessary in script:
// interpreter.set("__file__", <myFile>);
// set system argument variables (one append per variable):
interpreter.exec("sys.argv.append('".concat("<myVar>").concat("')"));
interpreter.execfile("<fileWithQualifiedPath>");
PyObject importIcalPy = interpreter.get("import_ical");
PyObject pythonResult = importIcalPy.__call__(new PyString("<myScriptArgument>"));