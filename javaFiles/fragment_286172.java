public class IsValidResellerIdFunction extends AbstractFunction implements ConfigurableFunction {

    private ResellerService resellerService;

    public void setResellerService(ResellerService resellerService) {
        this.resellerService = resellerService;
    }

    public IsValidResellerIdFunction() {}

    @Override
    public int getExpectedNumberOfArguments() {
        return 1;
    }

    @Override
    public void setArguments(int expectedNumberOfArguments, Function[] arguments,
            int line, int column) {
        super.setTemplate(line, column);
        super.setArguments(arguments);
        super.definedExactNumberOfArguments(expectedNumberOfArguments);
    }

    @Override
    protected Object doGetResult(Object o) throws Exception {
        String resellerId = (String) getArguments()[0].getResult(o);
        return resellerService.isValidResellerId(resellerId);
    }

}