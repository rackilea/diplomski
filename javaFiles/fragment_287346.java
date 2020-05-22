StringBuffer sb = new StringBuffer();
sb.append("do shell script \"qlmanage -p \" & \"somepath/somefile\"").append("\n")

ScriptEngineManager mgr = new ScriptEngineManager();
ScriptEngine engine = mgr.getEngineByName("AppleScript");
try {
    engine.eval(sb.toString());
} catch (ScriptException e) {
    e.printStackTrace();
}