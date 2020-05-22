String op = '+';
int first= 10;
int second = 20;
ScriptEngineManager scm = new ScriptEngineManager();
ScriptEngine jsEngine = scm.getEngineByName("JavaScript");
Integer result = (Integer) jsEngine.eval(first+op+second);