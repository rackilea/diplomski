public static void main(String[] args) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        try {
            Boolean eval = (Boolean) engine.eval("40 > 10");
            assert(eval);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }