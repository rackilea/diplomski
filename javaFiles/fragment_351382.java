public interface ScriptLoader {
  public String getScriptContent(String relativePath);
}

ScriptLoader loader;
ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
engine.eval(loader.getScriptContent('myScript.js'));