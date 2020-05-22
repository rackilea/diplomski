try {
    System.out.println(equa);
    funcVal = ((Number) engine.eval(equa)).doubleValue();
} catch (ScriptException e) {
    e.printStackTrace();
}