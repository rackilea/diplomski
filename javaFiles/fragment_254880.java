public class FlowCInput {
    private int output1FromB; // suppose that it is int
    private String output2FromA; // suppose that it is String
    private FlowCInput() { }
    //...

    public static class FlowCInputBuilder implements Builder<FlowCInput> {
        private final FlowCInput result;

        public FlowCInputBuilder(FlowBOutput mandatoryflowBOutput) {
            result = new FlowCInput();
            // output1FromB is private but still accessed from here
            result.output1FromB = mandatoryflowBOutput.getOutput1FromB();
        }

        public FlowCInputBuilder setOptionalflowAOutput(FlowAOutput optionalflowAOutput) {
            // same for output2FromA
            result.output2FromA = optionalflowAOutput.getOutput2FromA();
            return this;
        }

        @Override
        public FlowCInput build() {
            return result;
        }
    }
}