boolean validExpression = true;

ScriptEngineManager mgr = new ScriptEngineManager();
ScriptEngine engine = mgr.getEngineByName("JavaScript");
String input = textField.getText() // Modify this to whatever variable you have assigned to your text field

try {
    System.out.println(engine.eval(foo));
} 
catch (ScriptException e) {
    validExpression = false;
    System.out.println("Invalid Expression");
}