@Test
public void getFooListWithMockUpTest(@Mocked final Foo mockFoo){

    new MockUp<FooStatement>(){
        @Mock
        public List<Foo> getFoos(){
            return new ArrayList<Foo>(Arrays.asList(mockFoo));
        }
    };

    List<FooStatement> fooStatementList = new ArrayList<>(Arrays.asList(
            new FooStatement(),
            new FooStatement()
    ));

    List<Foo> fooList = Deencapsulation.invoke(handler, "getFooList",     fooStatementList);
    Assert.assertTrue(fooList.size() == 2);
}