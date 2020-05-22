public class SplitLine extends BaseOperation implements Function {

    public SplitLine() {
        super(1, new Fields("name"));
    }

    @Override
    public void operate(FlowProcess flowProcess, FunctionCall functionCall) {
        TupleEntry arguments = functionCall.getArguments();

        String line = arguments.getString(0);
        String[] tokens = line.split("\t");

        // Check that the split worked as assumed.
        if (tokens.length == 3) {
            Tuple output = new Tuple("name");
            output.set(0, tokens[0]);

            functionCall.getOutputCollector().add(output);
        }
    }
}