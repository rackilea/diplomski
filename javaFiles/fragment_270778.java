private void doSomething(Map<String, String> someArguments) {
    MyEnum runType = getRunType(someArguments);
    switch (runType) {
        case FRUIT:
            synchronized (FruitClass.class){
                new FruitClass().workNow();
            }
            break;

        case VEGETABLE:
            synchronized (VegetableClass.class){
                new VegetableClass().workNow();
            }
            break;

        default:
            // log that the type is not known 
    }
}