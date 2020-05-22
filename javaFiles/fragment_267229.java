public class ComplexComputation {
    public static final ThreadLocal<Map<String, Object>> DATA 
        = new ThreadLocal<Map<String, Object>>();

    public Result compute(Inputs inputs) {
        // ... do something ...
        if (DATA.get() != null) { DATA.get().put("intermediate", intermediate); }
        // ... do something ...
        return result;
    }
}

public void computationDebuggingCaller() {
    ComplexComputation.DATA.set(new HashMap<String, Object>());
    new ComplexComputation().compute(...);
    Object intermediate = ComplexComputation.DATA.get().get("intermediate");
}