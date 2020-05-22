public static class Function {
    private final ScriptEngine engine;

    public Function() {
        ScriptEngineManager mgr = new ScriptEngineManager();
        engine = mgr.getEngineByName("javascript");
    }

    public void plot(Graphics2D g2, double x1, double y1, double x2, double y2) {
        Line2D.Double seg = new Line2D.Double(x1, y1, x2, y2);
        g2.draw(seg);
    }

    public double functionVal(double x, String equa) {
        try {
            System.out.println(equa);
            funcVal = ((Number) engine.eval(equa)).doubleValue();
        } catch (ScriptException e) {
        }
        return funcVal;
    }
    private double funcVal;
}