public class Main {
    private static final class NonSplittingSpliter implements IParameterSplitter {
        public List<String> split(String value) {
            return Collections.singletonList(value);
        }
    }
    @Parameter(names={"-P"},
            splitter = NonSplittingSpliter.class,
            variableArity = true)
    public List<String> values = Collections.emptyList();

    public static void main(String ... argv) {
        Main main = new Main();
        JCommander.newBuilder()
                .addObject(main)
                .build()
                .parse(argv);
        main.run();
    }

    public void run() {
        for (String val: values) {
            System.out.println(val);
        }
    }
}