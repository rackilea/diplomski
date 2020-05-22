String content = FileUtils.readFileToString(new File("c:/temp/json.txt"), "UTF-8");

PythonInterpreter pi = new PythonInterpreter();
pi.exec("import json");
pi.exec("jsondata = " + content);
pi.exec("jsonCleaned = json.dumps(jsondata)");
PyObject jsonCleaned = (PyObject) pi.get("jsonCleaned");
System.out.println(jsonCleaned.asString());
pi.close();