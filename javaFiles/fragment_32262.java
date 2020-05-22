Collection<MyCustomRunTimeException> testItOutCollection;



    Exception exampleOne = new MyCustomRunTimeException();
    Exception exampleTwo = new Exception(new MyCustomRunTimeException());
    Exception exampleThree = new Exception(new Exception(new MyCustomRunTimeException()));
    Exception exampleFour = new Exception(new Exception(new MyCustomRunTimeException(new ArithmeticException())));
    MyCustomRunTimeException exampleFive = new MyCustomRunTimeException(new MySubMyCustomRunTimeException(new MyCustomRunTimeException(new ArithmeticException())));

    testItOutCollection = this.aggregateSubClassExceptions(exampleOne, MyCustomRunTimeException.class);
    testItOutCollection = this.aggregateSubClassExceptions(exampleTwo, MyCustomRunTimeException.class);
    testItOutCollection = this.aggregateSubClassExceptions(exampleThree, MyCustomRunTimeException.class);
    testItOutCollection = this.aggregateSubClassExceptions(exampleFour, MyCustomRunTimeException.class);
    testItOutCollection = this.aggregateSubClassExceptions(exampleFive, MyCustomRunTimeException.class);