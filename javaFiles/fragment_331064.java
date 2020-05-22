class MyStrategyFactory {

    public void createMyStrategy() {
        // ...
        if ( deviceIsAsus ) {
            return new MyStrategyForAsus();
        }
        if ( deviceIsLg ) {
            return new MyStrategyForLG();
        }
        return new DefaultMyStrategy();
    }
}