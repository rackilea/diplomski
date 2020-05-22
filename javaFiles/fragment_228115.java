interface OrderInitializeStrategy {
    Order initialize();
}

class InitializeOrderBasedOnProvidedValue implements OrderInitializeStrategy {
    private final String orderValue;

    public InitializeOrderBasedOnProvidedValue(String orderValue) {
        this.orderValue = orderValue;
    }

    @Override
    public Order initialize() {
        // user argument will never be used here, all I need is orderValue 
    }
}

class DefaultOrderInitializer implements OrderInitializeStrategy {
    private final User user;

    public DefaultOrderInitializer(User user) {
        this.user = user;
    }

    @Override
    public Order initialize() {
        // need only user and probably there maybe more arguments, but orderValue will never be used
    }
}