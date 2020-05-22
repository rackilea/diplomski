private ValueNumberDataflow vna;
private Map<ValueNumber, String> vnToParameterName;

@Override
public void visit(Code code) {
    try {
        this.vna = getClassContext().getValueNumberDataflow(getMethod());
    } catch (DataflowAnalysisException | CFGBuilderException e) {
        bugReporter.logError("Unable to get VNA for "+getMethodDescriptor(), e);
        return;
    }
    this.vnToParameterName = new HashMap<>();
    super.visit(code);
}