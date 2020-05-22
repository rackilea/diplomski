@State(Scope.Benchmark)
public class StringConcat {
    private final MyClass clazz = new MyClass();

    static class MyClass {
        private String name;

        public String getName() {
            if (name == null) name = "ZZZ";
            return name;
        }
    }

    @Param({"1", "100", "400", "1000"})
    private int pollutionCalls;

    @Setup
    public void setup() {
        for (int i = 0; i < pollutionCalls; i++) {
            new MyClass().getName();
        }
    }

    @Benchmark
    public String fast() {
        String clazzName = clazz.getName();
        return "str " + clazzName;
    }

    @Benchmark
    public String slow() {
        return "str " + clazz.getName();
    }
}