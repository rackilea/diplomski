try {
        final ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
        final Object result = engine.eval("23+33-34*2^2");
        System.out.println(result);
    } catch (final ScriptException e) {

        e.printStackTrace();
    }