class MyProjectImplTest {

    @TestFactory
    Collection<DynamicTest> test() {
       return new CommonTestSuite(new ASource()).tests();
    }
}