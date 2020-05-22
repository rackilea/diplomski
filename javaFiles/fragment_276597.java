public Class1Test {

    private Class1 class1;

    private Class2 class2;

    @BeforeMethod
    public void initMocks(){
        class2 = mock(Class2.class);
        class1 = new Class1(class2);
    }
   //then use the same approach to mock any methods that you need
}