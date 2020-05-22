@Override
public TypedValue getValueInternal(ExpressionState state) throws EvaluationException {
    if (!getBooleanValue(state, getLeftOperand())) {
        // no need to evaluate right operand
        return BooleanTypedValue.FALSE;
    }
    return BooleanTypedValue.forValue(getBooleanValue(state, getRightOperand()));
}