class ImplementationOfAbstractUsefulService extends AbstractUsefulService{
    private final SecondChildCalculator secondChildCalculator;

    public ImplementationOfAbstractUsefulService(
        SecondChildCalculator calculator
    ) {
        super(calculator);
    }

    public void doJob(){
        secondChildCalculator.calculateValue(new SecondChild());
    }
}