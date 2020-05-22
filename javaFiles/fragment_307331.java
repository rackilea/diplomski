public static void main(String[] args) throws ScriptException {
    ScriptEngineManager sem = new ScriptEngineManager();
    ScriptEngine se = sem.getEngineByExtension("js");

    String s= "(resultSet.get(\"PRIMARY_ROLE\")=='COO Business Management Team' && resultSet.get(\"DEPT_LEVEL\")=='5') ? 1:0";
    Bindings bindings = se.createBindings();
    bindings.put("resultSet",
            new HashMap<String, String>() {{
                put("PRIMARY_ROLE","COO Business Management Team");
                put("DEPT_LEVEL","5");
            }});

    Object result = se.eval(s, bindings);
    System.out.println("Expression evaluates to "+ result);
}