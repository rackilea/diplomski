import cascading.flow.FlowProcess;
import cascading.operation.BaseOperation;
import cascading.operation.Function;
import cascading.operation.FunctionCall;
import cascading.tuple.Fields;
import cascading.tuple.TupleEntry;

public class TestFunction extends BaseOperation<Void> implements Function<Void> {

    private static final long serialVersionUID = 1L;

    private static final String DECIDING_FACTOR = "No";
    private static final String DEFAULT_VALUE = "N/A";

    // Expected Fields: "F1DecidingFactor", "F1Output", "F2DecidingFactor", "F2Output"
    public TestFunction() {
        super(Fields.ARGS);
    }

    @Override
    public void operate(@SuppressWarnings("rawtypes") FlowProcess process, FunctionCall<Void> call) {
        TupleEntry arguments = call.getArguments();

        TupleEntry result = new TupleEntry(arguments);

        if (result.getString("F1DecidingFactor").equalsIgnoreCase(DECIDING_FACTOR)) {
            result.setString("F1Output", DEFAULT_VALUE);
        }

        if (result.getString("F2DecidingFactor").equalsIgnoreCase(DECIDING_FACTOR)) {
            result.setString("F2Output", DEFAULT_VALUE);
        }

        call.getOutputCollector().add(result);
    }

}