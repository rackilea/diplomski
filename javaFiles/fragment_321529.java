@Override
protected void processOperator(Operator operator, List<COSBase> operands) throws IOException {
    if (inOperator) {
        super.processOperator(operator, operands);
    } else {
        inOperator = true;
        nextOperation(operator, operands);
        super.processOperator(operator, operands);
        write(replacement, operator, operands);
        inOperator = false;
    }
}

boolean inOperator = false;