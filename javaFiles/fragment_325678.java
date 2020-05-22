public double functionVal(double x, String equa) {
        try {
            System.out.println(equa);
            engine.put("x", 10);
            funcVal = ((Number) engine.eval(equa)).doubleValue();
            System.out.println(equa + " = " + funcVal);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return funcVal;
    }