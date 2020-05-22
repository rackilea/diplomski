String f = "function NumberEncoding(str) { str = str.toLowerCase();\n" 
        + "var obj = {};\n"
        + "var alpha = \"abcdefghijklmnopqrstuvwxyz\";\n" 
        + "var result = \"\";\n"
        + "for (var i = 1; i <= alpha.length; i++) {\n" 
        + "    obj[alpha[i-1]] = i;\n" + "}\n" + "\n"
        + "for (var j = 0; j < str.length; j++) {\n" 
        + "  if (str[j].match(/[a-z]/)) {\n"
        + "    result += obj[str[j]];\n" 
        + "  } else {\n" + "    result += str[j];" + "  }\n" + "}\n"
        + "return result;\n" + "}";
ScriptEngine se = new ScriptEngineManager().getEngineByName("js");
try {
    se.eval(f);
    Invocable invocable = (Invocable) se;
    Object result = invocable.invokeFunction("NumberEncoding", "zabc123");
    System.out.println(result);
} catch (Exception e) {
    e.printStackTrace();
}