class PrintImageLocationsImproved extends PrintImageLocations {
    public PrintImageLocationsImproved() throws IOException {
        super();

        addOperator(new SetNonStrokingColor());
        addOperator(new SetNonStrokingColorN());
        addOperator(new SetNonStrokingDeviceCMYKColor());
        addOperator(new SetNonStrokingDeviceGrayColor());
        addOperator(new SetNonStrokingDeviceRGBColor());
        addOperator(new SetNonStrokingColorSpace());
    }

    @Override
    protected void processOperator(Operator operator, List<COSBase> operands) throws IOException {
        String operation = operator.getName();
        if (fillOperations.contains(operation)) {
            PDColor color = getGraphicsState().getNonStrokingColor();
            PDAbstractPattern pattern = getResources().getPattern(color.getPatternName());
            if (pattern instanceof PDTilingPattern) {
                processTilingPattern((PDTilingPattern) pattern, null, null);
            }
        }
        super.processOperator(operator, operands);
    }

    final List<String> fillOperations = Arrays.asList("f", "F", "f*", "b", "b*", "B", "B*");
}